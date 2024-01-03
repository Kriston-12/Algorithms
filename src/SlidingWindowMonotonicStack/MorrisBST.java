package SlidingWindowMonotonicStack;

public class MorrisBST {
    public static boolean morrisInOrder(Node head) {
        if (head == null) {
            return true;
        }
        Node mostRight = null;
        Node cur = head;
        int preValue = Integer.MIN_VALUE;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }
                else {
                    mostRight.right = null;
                }
            }
            if (cur.value <= preValue) {
                return false;
            }
            preValue = cur.value;
            cur = cur.right;
        }
        return true;
    }
}
