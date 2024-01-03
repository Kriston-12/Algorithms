package Bitree;

public class GetSuccessorNode {

    public static Node getSuccessorNode(Node node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {  // 如果node有右树，右数上的最左节点就是要找的后节点
            return getLeft(node.right);
        }
        else {  // node 没有右tree的情况
            Node parent = node.parent;
            if (parent != null && node != parent.left) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    public static Node getLeft(Node node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
