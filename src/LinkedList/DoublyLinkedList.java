package LinkedList;

public class DoublyLinkedList {
    public static void main(String[] args) {
        HeroNode1 hero1 = new HeroNode1(1, "songjiang", "jishiyu");
        HeroNode1 hero2 = new HeroNode1(2, "lujunyi", "yuqilin");
        HeroNode1 hero3 = new HeroNode1(3, "wuyong", "zhiduoxing");
        HeroNode1 hero4 = new HeroNode1(4, "gongsunsheng", "ruyunlong");
        HeroNode1 hero5 = new HeroNode1(5, "guansheng", "meirangong");

        DLinkedList list2 = new DLinkedList();
        list2.add(hero1);
        list2.add(hero2);
        list2.add(hero3);
        list2.add(hero5);

        list2.addByRank(hero4);
        list2.printList();

    }
}
class DLinkedList {
    private HeroNode1 head = new HeroNode1(0, "", "");

    public void add(HeroNode1 node) {
        HeroNode1 temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    public void printList() {
        if (head == null) {
            return;
        }
        HeroNode1 temp = head;
        while (temp.next != null) {
            temp = temp.next;
            System.out.println(temp);
        }
    }

    public void addByRank(HeroNode1 node) {
       HeroNode1 temp = head;
       boolean flag = false;
       while (temp.next != null) {
           if (temp.next.rank == node.rank) {
               System.out.println("The hero is already in the list");
               return;
           }
           else if (temp.next.rank > node.rank) {
               node.next = temp.next;
               temp.next.pre = node;
               temp.next = node;
               node.pre = temp;
               return;
           }
           temp = temp.next;
       }
       temp.next = node;
       node.pre = temp;
    }
}



class HeroNode1 {
    int rank;
    String nickName;
    String name;
    HeroNode1 next;
    HeroNode1 pre;

    public HeroNode1(int rank1, String nickName, String name1) {
        this.rank = rank1;
        this.nickName = nickName;
        this.name = name1;
    }

    @Override
    public String toString() {
        return "HeroNode1{" +
                "rank=" + rank +
                ", nickName='" + nickName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}