package Bitree;

import java.util.LinkedList;

@SuppressWarnings({"all"})
public class CheckCompleteBitree {
    // 遇到的任意节点，如果只有右孩子，返回false
    public static boolean isCBT(Node head) {
        if (head == null) {
            return true;
        }
        LinkedList<Node> queue = new LinkedList<>();
        boolean leaf = false;  // 表示是否遇到过左右孩子不全的Node
        Node l = null;
        Node r = null;
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            if ((leaf && (l != null || r != null)  // 发现不双全节点后遇到非叶节点
            || (l == null && r != null))) {
                return false;
            }
            if (l != null) {
                queue.add(l);
            }
            if (r != null) {
                queue.add(r);
            }
            if (l == null || r == null) {
                leaf = true;
            }
        }
        return true;
    }
}
