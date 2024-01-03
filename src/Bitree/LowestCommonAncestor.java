package Bitree;

import java.util.HashMap;
import java.util.HashSet;

public class LowestCommonAncestor {

    public static Node LCA(Node head, Node o1, Node o2) {
        HashMap<Node, Node> fatherMap = new HashMap<>();
        fatherMap.put(head, head);
        process(head, fatherMap);
        HashSet<Node> set01 = new HashSet<>();
        Node cur = o1;
        while (cur != fatherMap.get(cur)) {
            set01.add(cur);
            cur = fatherMap.get(cur);
        }
        set01.add(head);

        while (!set01.contains(o2)) {
            o2 = fatherMap.get(o2);
        }
        return o2;
    }

    public static void process(Node head, HashMap<Node, Node> fatherMap) {
        if (head == null) {
            return;
        }
        fatherMap.put(head.left, head);
        fatherMap.put(head.right, head);
        process(head.left, fatherMap);
        process(head.right, fatherMap);
    }

    public static Node LCA1(Node head, Node o1, Node o2) {
        if (head == null || head == o1 || head == o2) {
            return head;
        }
        Node left = LCA1(head.left, o1, o2);
        Node right = LCA1(head.right, o1, o2);
        if (left != null && right != null) {
            return head;
        }
        return left != null ? left : right;
    }
}
