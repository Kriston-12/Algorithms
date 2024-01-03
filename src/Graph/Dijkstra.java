package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Dijkstra {
    // 使用范围，不能有累加和值为复数的环，否则会转起来
    public static HashMap<Node, Integer> dijkstra(Node head) {
        // 从head到所有点的最短距离
        // key: 从head出发到key
        // value： 从head出发到达key的最小距离
        // 如果在表中： 没有T的记录，含义是从head到T这个点的距离为正无穷
        HashMap<Node, Integer> distanceMap = new HashMap<>();
        distanceMap.put(head, 0);
        // 已经求过距离的节点，存在selectedNodes中，以后再也不碰
        HashSet<Node> selectedNodes = new HashSet<>();
        // Node minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);// this is not necessary as we only have head at first
        Node minNode = head;
        while (minNode != null) {
            int distance = distanceMap.get(minNode);
            for (Edge edge : minNode.edges) {
                Node toNode = edge.to;
                if (!distanceMap.containsKey(toNode)) {
                    distanceMap.put(toNode, distance + edge.weight);
                }else {
                    distanceMap.put(edge.to, Math.min(distanceMap.get(toNode), distance + edge.weight));
                }
            }
            selectedNodes.add(minNode);
            minNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        }
        return distanceMap;
    }

    public static Node getMinDistanceAndUnselectedNode(
            HashMap<Node, Integer> distanceMap,
            HashSet<Node> touchedNodes
    ) {
        Node minNode = null;
        int minDistance = Integer.MAX_VALUE;
        for (Map.Entry<Node, Integer> entry: distanceMap.entrySet()) {
            Node node = entry.getKey();
            int distance = entry.getValue();
            if (!touchedNodes.contains(node) && distance < minDistance) {
                minNode = node;
                minDistance = distance;
            }
        }
        return minNode;
    }

    // just wanna write Dijkstra on my own
    public static HashMap<Node, Integer> Dijkstra2(Node head) {
        HashMap<Node, Integer> distanceMap = new HashMap<>();  // the big map that contains all things
        distanceMap.put(head, 0);
        HashSet<Node> selectedNodes = new HashSet<Node>();
//        selectedNodes.add(head);
        Node minNode = head;
        while (minNode != null) {
            int distance = distanceMap.get(minNode);
            for (Edge edge : minNode.edges) {
                Node to = edge.to;
                if (distanceMap.containsKey(to)) {
                    distanceMap.put(to, distance + edge.weight);
                }
                else {
                    distanceMap.put(to, Math.min(distance + edge.weight, distanceMap.get(to)));
                }
            }
            selectedNodes.add(minNode);
            minNode = getMinNode(distanceMap, selectedNodes);
        }
        return distanceMap;
    }

    public static Node getMinNode(HashMap<Node, Integer> distanceMap, HashSet<Node> selectedNodes) {
        int minDis = Integer.MAX_VALUE;
        Node minNode = null;
        for (Map.Entry<Node, Integer> entry : distanceMap.entrySet()) {
            Node node = entry.getKey();
            int value = entry.getValue();
            if (!selectedNodes.contains(node) && value < minDis) {
                minNode = node;
                minDis = value;
            }
        }
        return minNode;
    }


    // 改进后的dijkstra
    public static HashMap<Node, Integer> dijkstra2(Node head, int size) {
        NodeHeap nodeHeap = new NodeHeap(size);
        nodeHeap.addOrUpdateOrIgnore(head, 0);
        HashMap<Node, Integer> result = new HashMap<>();
        while(!nodeHeap.isEmpty()) {
            NodeRecord record = nodeHeap.pop();
            Node cur = record.node;
            int distance = record.distance;
            for(Edge edge : cur.edges) {
                nodeHeap.addOrUpdateOrIgnore(edge.to, edge.weight + distance);
            }
            result.put(cur, distance);
        }
        return result;
    }

    public static class NodeRecord {
        public Node node;
        public int distance;  // If refers to the shortest distance between the head node and the last line node(line 59);
        public NodeRecord(Node node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
    public static class NodeHeap {
        private Node[] nodes;       // 这是一个node的堆
        private HashMap<Node, Integer> heapIndexMap; // node再堆中对应的index的map
        private HashMap<Node, Integer> distanceMap;
        private int size;

        public NodeHeap(int size) {
            nodes = new Node[size];
            heapIndexMap = new HashMap<>();
            distanceMap = new HashMap<>();
            this.size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        private boolean isEntered(Node node) {
            return heapIndexMap.containsKey(node);  // 如果node在小分堆排序的过程中被弹出，就令其的index为-1
        }

        private boolean isHeap(Node node) {
            return heapIndexMap.containsKey(node) && heapIndexMap.get(node) != -1;
        }

        private void swap(int index1, int index2) {
            heapIndexMap.put(nodes[index1], index2);
            heapIndexMap.put(nodes[index2], index1);
            Node temp = nodes[index1];
            nodes[index1] = nodes[index2];
            nodes[index2] = temp;
        }

        private void insertHeapify(Node node, int index) {
            while (heapIndexMap.get(nodes[index]) < heapIndexMap.get(nodes[(index - 1) / 2])) {
                swap(index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        public void addOrUpdateOrIgnore(Node node, int distance) {
            if (isHeap(node)) {
                distanceMap.put(node, Math.min(distanceMap.get(node), distance));
                insertHeapify(node, heapIndexMap.get(node));
            }
            if (!isEntered(node)) {
                nodes[size] = node;
                distanceMap.put(node, distance);
                heapIndexMap.put(node, size);
                insertHeapify(node, size++);
            }
        }

        public NodeRecord pop() {
            NodeRecord nodeRecord = new NodeRecord(nodes[0], distanceMap.get(nodes[0]));
            swap(0, size - 1);
            heapIndexMap.put(nodes[size - 1], -1);
            distanceMap.remove(nodes[size - 1]);
            // for c or c++, free nodes[size - 1] or delete nodes[size - 1]
            nodes[size - 1] = null;
              // heapify(0, size--)

            return nodeRecord;
        }

        public void heapify(int index, int size) {
            int left = 2 * index + 1;
            while (left < size) {
                int largest = distanceMap.get(nodes[left]) > distanceMap.get(nodes[left + 1]) ?
                        left : left + 1;
                largest = distanceMap.get(nodes[largest]) > distanceMap.get(nodes[index]) ? largest : index;
                if (largest == index) {
                    break;
                }
                swap(largest, index);
                index = largest;
                left = 2 * index + 1;
            }
        }
    }

}
