package Bitree;

public class CheckFullBiTree {

    public static class info {
        public int height;
        public int nodes;

        public info() {}
        public info(int hei, int no) {
            this.height = hei;
            this.nodes = no;
        }
    }

    public boolean checkFullTree(Node head) {
        if (head == null) {
            return true;
        }
        info data = process(head);
        return data.nodes == (1 << data.height  - 1);
    }

    public static info process(Node head) {
        if (head == null) {
            return null;
        }

        info leftTree = process(head.left);
        info rightTree = process(head.right);
        int height = Math.max(leftTree.height, rightTree.height) + 1;
        int nodes = leftTree.nodes + rightTree.nodes + 1;

        return new info(height, nodes);
    }
}
