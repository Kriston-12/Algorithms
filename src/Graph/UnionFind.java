package Graph;

import java.util.*;

public class UnionFind {


}

class MySet {
    public static HashMap<Node, List<Node>> setMap;

    public MySet(List<Node> nodes) {
        for (Node cur : nodes) {
            List<Node> set = new ArrayList<>();
            set.add(cur);
            setMap.put(cur, set);
        }
    }

    public boolean isSameSet(Node from, Node to) {
        List<Node> fromSet = setMap.get(from);
        List<Node> toSet = setMap.get(to);
        return fromSet == toSet;
    }

    public void union(Node from, Node to) {
        List<Node> fromSet = setMap.get(from);
        List<Node> toSet = setMap.get(to);
        for (Node toNode: toSet) {
            fromSet.add(toNode);
            setMap.put(toNode, fromSet);
        }
    }


    // method 2:

    public static class EdgeComparator implements Comparator<Edge> {
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    public static Set<Edge> prim(Graph graph) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());

        HashSet<Node> set = new HashSet<>();

        Set<Edge> result = new HashSet<>(); // 依此挑选的边放在result里

        for (Node node : graph.nodes.values()) {  // 此for循环是处理分离问题，如果默认处理的是连在一起的node则不需要这个for
            if (!set.contains(node)) {
                set.add(node);
                for (Edge edge: node.edges) { //由一个点，解锁所有相邻的边
                    priorityQueue.add(edge);
                }
                while (!priorityQueue.isEmpty()) {
                    Edge edge = priorityQueue.poll();   // 弹出解锁的边中，最小的边
                    Node toNode = edge.to;
                    if (!set.contains(toNode)) {
                        set.add(toNode);
                        result.add(edge);
                        for (Edge nextEdge : toNode.edges) {
                            priorityQueue.add(nextEdge);
                        }
                    }
                }
            }

        }
        return result;
    }

}

