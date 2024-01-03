package LinkedList;

public class SingleLinkedList {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "songjiang", "jishiyu");
        HeroNode hero2 = new HeroNode(2, "lujunyi", "yuqilin");
        HeroNode hero3 = new HeroNode(3, "wuyong", "zhiduoxing");
        HeroNode hero4 = new HeroNode(4, "gongsunsheng", "ruyunlong");
        HeroNode hero5 = new HeroNode(5, "guansheng", "meirangong");

        HeroNode newHero = new HeroNode(2, "linchong", "baozitou");
        LinkedList list1 = new LinkedList();
//        list1.add(hero1);
//        list1.add(hero2);
//        list1.add(hero3);
//        list1.add(hero4);
//        list1.add(hero5);
        list1.addByRank(hero2);
        list1.addByRank(hero1);
        list1.addByRank(hero3);
        list1.printList();
        System.out.println();
        list1.changeNode(newHero);
        list1.printList();
        list1.removeNode(hero2);
        System.out.println();
        list1.printList();
    }
}


class LinkedList {
    private HeroNode head = new HeroNode(0, "", "");

    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public void printList() {
        if (head.next == null) {
            System.out.println("The list is empty");
            return;
        }
        HeroNode temp = head;
        while (temp.next != null){
            temp = temp.next;
            System.out.println(temp);
        }
    }

    public void addByRank(HeroNode node) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null){
                break;
            }
            else if (temp.next.rank > node.rank){
                break;
            }
            else if (temp.next.rank == node.rank){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag) {
            System.out.println("The hero is already in the list");
            return;
        }
        else {
            node.next = temp.next;
            temp.next = node;
        }
    }

    public void changeNode(HeroNode node) {
        HeroNode temp = head.next;
        while (temp != null) {
            if (temp.rank == node.rank) {
                temp.name = node.name;
                temp.nickName = node.nickName;
                return;
            }
            temp = temp.next;
        }
        System.out.println("We have no such rank in the list");
    }

    public void removeNode(HeroNode node) {
        HeroNode temp = head;
        while (temp.next != null) {
            if (temp.next == node) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
        System.out.println(node + "is not in the linked list");
    }
}

class HeroNode {
    int rank;
    String name;
    String nickName;
    HeroNode next;

    public HeroNode(int rank1, String name1, String nickName1) {
        this.rank = rank1;
        this.name = name1;
        this.nickName = nickName1;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "rank=" + rank +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}