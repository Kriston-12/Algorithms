package Bitree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
@SuppressWarnings({"all"})

public class CheckBST {
    // 判断一个biTree是不是binary search tree
    public static long preValue = Integer.MIN_VALUE;
    public static boolean isValidBST(Node root) {
        if (root == null) {
            return true;
        }
        boolean isLeft = isValidBST(root.left);
        if (!isLeft) {
            return false;
        }
        if (root.value <= preValue) {
            return false;
        }
        else {
            preValue = root.value;
        }
        return isValidBST(root.right);
    }
    // bst method2
    public static boolean checkBST2(Node head) {
        List<Node> inOrderList = new ArrayList<>();
        process2(head, inOrderList);
        for (int i = 0; i < inOrderList.size() - 1; i++) {
            if (inOrderList.get(i + 1).value < inOrderList.get(i).value) {
                return false;
            }
        }
        return true;
    }
    public static void process2(Node head, List<Node> inOrderList) {
        if (head == null) {
            return;
        }
        process2(head.left, inOrderList);
        inOrderList.add(head);
        process2(head.right, inOrderList);
    }

    public static boolean checkBST3(Node head) {
        if (head == null) {
            return true;
        }
        int preValue = Integer.MIN_VALUE;
        Stack<Node> stack = new Stack<Node>();
        while (head != null || !stack.isEmpty()) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            }
            else {
                head = stack.pop();
                if (head.value < preValue) {
                    return false;
                }
                else {
                    preValue = head.value;
                }
                head = head.right;
            }
        }
        return true;
    }

    public static boolean checkBst4(Node head) {
        if (head == null) {
            return true;
        }
        return process(head).isBST;
    }

    public static ReturnType process(Node head) {
        if (head == null) {
            return null;
        }
        int min = head.value;
        int max = head.value;
        ReturnType leftData = process(head.left);
        ReturnType rightData = process(head.right);

        if (leftData != null) {
            min = Math.min(min, leftData.min);
            max = Math.max(max, leftData.max);
        }
        if (rightData != null) {
            min = Math.min(min, rightData.min);
            max = Math.min(max, rightData.max);
        }

        boolean isBst = true;
        if (leftData != null && !leftData.isBST) {
            isBst = false;
        }
        if (rightData != null && !rightData.isBST) {
            isBst = false;
        }
        return new ReturnType(isBst, max, min);
    }
}

class ReturnType {

    int max;
    int min;
    public boolean isBST;

    public ReturnType() {
    }
    public ReturnType(boolean is, int max, int min) {
        this.isBST = is;
        this.max = max;
        this.min = min;
    }
}