package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstSearch {
    public static void BFS(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<Node>();
        HashSet<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            for (Node next : cur.nexts) {
                if (!set.contains(next)){
                    queue.add(next);        // queue can have duplicate elements in it while Set cannot
                    set.add(next);
                }
            }
        }
    }
}
