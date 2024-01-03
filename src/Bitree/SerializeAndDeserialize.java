package Bitree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class SerializeAndDeserialize {
    public static String Serialize(Node head) {
        if (head == null) {
            return "#_";
        }
        String s = String.valueOf(head.value) + "_";
        s += Serialize(head.left);
        s += Serialize(head.right);
        return s;
    }

    public static Node Deserialize(String s) {
        String[] s1 = s.split("_");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < s1.length; i++) {
            queue.add(s1[i]);
        }
        return Reconstruct(queue);
    }

    public static Node Reconstruct(Queue<String> queue) {
        String value = queue.poll();
        if (Objects.equals(value, "#")) {
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left = Reconstruct(queue);
        head.right = Reconstruct(queue);
        return head;
    }
}
