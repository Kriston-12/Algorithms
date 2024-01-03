package SlidingWindowMonotonicStack;

public class Morris {
    public static void morris(Node head) {
        if (head == null) {
            return;
        }
        Node mostRight = null;
        Node cur = head;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {  // 有左子树    //有左子树的节点就可以来到两次
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {  // 第一次来到cur
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }
                else {  // mostRight.right = cur;
                    mostRight.right = null;
                }
            }
            cur = cur.right;
        }
    }

    // morris先序print
    public static void morrisPreOrder(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        Node mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    System.out.println(cur.value);
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            else {// 没有左子树的情况
                System.out.println(cur.value);
            }
            cur = cur.right;
        }
    }

    // morris中序print
    public static void morrisInOrder(Node head) {
        if (head == null) {
            return;
        }
        Node mostRight = null;
        Node cur = head;
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
                    System.out.println(cur.value);    // 或者把78行放到cur = cur.right 上方，再去掉81 - 83行的else，道理是一样的
                }
            }
            else {
                System.out.println(cur.value);
            }
            cur = cur.right;
        }
    }

    // Morris后续遍历以及一些子函数
    public static void morrisPostOrder(Node head) {
        if (head == null) {
            return;
        }
        Node mostRight = null;
        Node cur = head;
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
                } else {   // 第二次回到自己时逆序打印自己的左子树
                    mostRight.right = null;
                    reversePrint(cur.left);
                }
            }
            cur = cur.right;
        }
        reversePrint(head.right);
    }

    public static void reversePrint(Node head) {
        Node tail = reverseEdge(head);
        Node cur = tail;
        while (cur.right != null) {
            System.out.println(cur.value);
            cur = cur.right;
        }
        reverseEdge(tail);
    }

    public static Node reverseEdge(Node head) {
        Node pre = null;
        Node next = null;
        Node from = head;
        while (from.right != null) {
            next = from.right;
            from.right = pre;
            pre = from;
            from = next;
        }
        return from;
    }


}

class Node {
    int value;
    Node left;
    Node right;
}
