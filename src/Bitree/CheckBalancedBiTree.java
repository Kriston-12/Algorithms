package Bitree;

public class CheckBalancedBiTree {
    public static class ReturnType {
        public boolean isBalanced;
        public int height;
        public ReturnType(boolean isB, int hei) {
            this.isBalanced = isB;
            this.height = hei;
        }
    }
    public static boolean isBalanced(Node head) {
        return process(head).isBalanced;
    }

    public static ReturnType process(Node x) {
        if (x == null) {
            return new ReturnType(true, 0);
        }

        ReturnType leftData = process(x.left);
        ReturnType rightData = process(x.right);

        int height = Math.max(leftData.height, rightData.height) + 1;
        boolean isBalanced = Math.abs(leftData.height - rightData.height) < 2 && leftData.isBalanced && rightData.isBalanced;
        return new ReturnType(isBalanced, height);
    }
}

