package Bitree;

import java.util.*;

@SuppressWarnings({"all"})

public class LoopThrough {
    public static void preOrderUnrecur(Node head) {
        System.out.println("Pre-order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<Node>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.println(head.value + " ");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    public static void postOrderUnrecur(Node head) {
        System.out.println("Post-order: ");
        if (head != null) {
            Stack<Node> s1 = new Stack<Node>();
            Stack<Node> s2 = new Stack<Node>();
            s1.push(head);
            while (!s1.isEmpty()) {
                head = s1.pop();
                s2.push(head);
                if (head.left != null) {
                    s1.push(head.left);
                }
                if (head.right != null) {
                    s1.push(head.right);
                }
            }
           while (!s2.isEmpty()) {
                System.out.println("value: " + s2.pop().value);
            }
        }

    }

    public static void inOrderUnrecur(Node head) {
        System.out.println("In-order: ");
        if (head != null) {
            Stack<Node>s1 = new Stack<Node>();
            while (!s1.isEmpty() || head != null) {
                if (head != null) {
                    s1.push(head);
                    head = head.left;
                }
                else {
                    head = s1.pop();
                    System.out.println(head.value + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    // 宽度遍历，从左到右
    public static void widthThrough(Node head) {
        if (head == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            Node cur = queue.poll(); // poll 相当于出队列的数类似于pop
            System.out.println(cur.value);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    // 得到bitree中最宽的level
    public static int getTheWidestBase(Node head) {
        if (head == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        HashMap<Node, Integer> levelMap = new HashMap<>();
        levelMap.put(head, 1);
        int curLevel = 1;
        int curLevelNodes = 0;
        int max = -1; // or int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int curNodeLevel = levelMap.get(cur);
            if (curNodeLevel == curLevel) {
                curLevelNodes++;
            }
            else {
                max = Math.max(max, curLevelNodes);
                curLevel++;
                curLevelNodes = 1;
            }
            if (cur.left != null) {
                levelMap.put(cur.left, curNodeLevel + 1); // I feel curLevel + 1 here would also be ok as they are equal, its curNodeLevel in the video tho
                queue.add(cur.left);
            }
            if (cur.right != null) {
                levelMap.put(cur.right, curLevel + 1);
                queue.add(cur.right);
            }
        }
        return max;
    }

    public static int getWidestLevelBaseNonHash(Node head)  {
        if (head == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        int curLevelNodes = 0;
        int max = -1;
        Node nextEnd = null;  // 下一层中最后一个节点
        queue.add(head);
        while (!queue.isEmpty()) {
            Node curEnd = queue.poll();   // 当前层中最后一个节点
            curLevelNodes++;
            if (curEnd.left != null) {
                queue.add(curEnd.left);
                nextEnd = curEnd.left;
            }
            if (curEnd.right != null) {
                queue.add(curEnd.right);
                nextEnd = curEnd.right;
            }
            if (curEnd == nextEnd) {
                max = Math.max(curLevelNodes, max);
                curLevelNodes = 0;
                nextEnd = null;
            }
        }
        return max;
    }


}

class Node {
    public Node parent;
    Node left;
    Node right;
    int value;
    public Node(int i) {
        this.value = i;
    }
}

class BiTree {
    Node head;
}
