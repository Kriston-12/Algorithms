package InterProbP26;

import java.util.TreeMap;

public class GetFolderTree {
    public static class Node {
        public String value;
        public TreeMap<String, Node> next;
        public Node(String str) {
            value = str;
            next = new TreeMap<>();
        }
    }
    public static Node generateFolderTree(String[] folderPaths) {
        if (folderPaths == null) {
            return null;
        }
        Node head = new Node("");
        for (String str : folderPaths) {
            String[] path = str.split("\\\\");  // its \\
            Node cur = head;
            for (int i = 0; i < path.length; i++) {
                if (!cur.next.containsKey(path[i])) {
                    cur.next.put(path[i], new Node(path[i]));
                }
                cur = cur.next.get(path[i]);
            }
        }
        return head;
    }
}
