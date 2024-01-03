package IntermediateProbP21P22;


public class TreeMaxSum {
    public static int maxSum = Integer.MIN_VALUE;
    public static int MaxSum(Node x) { // x是出发节点
        process(x, 0);
        return maxSum;
    }

    // 每个节点都必须走到根部，不能停留
    // 路径要求: 一定要从x出发，到叶节点，才算作一条路径
    public static void process(Node node, int pre) {
        if (node.left == null && node.right == null) {
            maxSum = Math.max(maxSum, pre + node.val);
            return;
        }
        if (node.left != null) {
            process(node.left, pre + node.val);
        }
        if (node.right != null) {
            process(node.right, pre + node.val);
        }
    }

    // 方法2，套路法
    public static int process2(Node node) {
        if (node.left == null && node.right == null) {
            return node.val;
        }
        int next = Integer.MIN_VALUE;
        if (node.left != null) {
            next = process2(node.left);
        }
        if (node.right != null) {
            next = Math.max(next, process2(node.right));
        }
        return node.val + next;
    }
}

class Node {
    Node left;
    Node right;
    int val;

    public Node(int val) {
        this.val = val;
    }
}