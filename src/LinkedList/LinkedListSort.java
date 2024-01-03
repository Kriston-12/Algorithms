package LinkedList;

// 将单链表按谋值划分成左边小，中间相等，右边大的形式
// 给定一个单链表的头节点head，节点的值是整形，再给定一个整数pivot。实现一个调整列表的函数，将列表调整为左部分都是小于pivot的节点，中间等于pivot，右边大于pivot。
// 要求： 排序过的列表元素相对顺序一样。 时间复杂杜达到O(N), 额外空间复杂度达到O(1)
public class LinkedListSort {
    public static Node listPartition2(Node head, int pivot) {
        Node sH = null;   //sH means small head
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node bH = null;
        Node bT = null;
        Node next = null; // save next node
        while (head.next != null) {
            next = head.next;
            head.next = null;
            if (next.value < pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            }
            if (next.value == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            }
            if (next.value > pivot) {
                if (bH == null) {
                    bH = head;
                    bT = head;
                }
                else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }
        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        if (eT != null) {
            eT.next = bH;
        }
        return sH != null ? sH : (eH != null ? eH : bH);
    }

    public class Node {
        int value;
        Node next;
        public Node(int data) {
            this.value = data;
        }
    }
}

