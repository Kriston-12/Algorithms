package SlidingWindowMonotonicStack;

public class MaxDistanceTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class Info {
        public int maxDistance;
        public int height;

        public Info(int maxDistance, int height) {
            this.maxDistance = maxDistance;
            this.height = height;
        }

        public int getMaxDistance(Node head) {
            return process(head).maxDistance;
        }

        public static Info process(Node node) {
            if (node == null) {
                return new Info(0, 0);
            }
            Info leftInfo = process(node.left);
            Info rightInfo = process(node.right);
            int p1 = leftInfo.maxDistance;
            int p2 = rightInfo.maxDistance;
            int p3 = leftInfo.height + rightInfo.height + 1;
            int maxDistance = Math.max(p3, Math.max(leftInfo.height, rightInfo.height));
            int height = Math.max(leftInfo.height, rightInfo.height) + 1;
            return new Info(maxDistance, height);
        }


    }
}
