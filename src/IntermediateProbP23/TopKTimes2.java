package IntermediateProbP23;

import java.util.HashMap;

// video see:  https://www.bilibili.com/video/BV13g41157hK/?p=23&vd_source=d67679eb2bbd122f6cd7f6d142b724f3 第一小时30分
public class TopKTimes2 {
    public static class Node  {
        public String str;
        public int times;
        public Node(String s, int t) {
            str = s;
            times = t;
        }
    }

    public static class TopKRecord {
        private HashMap<String, Node> strNodeMap;
        private Node[] heap;
        public HashMap<Node, Integer> nodeIndexMap;
        private int heapSize;

        public TopKRecord(int k) {
            heap = new Node[k];
            heapSize = 0;
            strNodeMap = new HashMap<String, Node>();
            nodeIndexMap = new HashMap<Node, Integer>();
        }

        public void add(String str) {
            Node curNode = null;
            int preIndex = -1;
            if (!strNodeMap.containsKey(str)) {
                curNode = new Node(str, 1);
                strNodeMap.put(str, curNode);
                nodeIndexMap.put(curNode, -1);
            }
            else {
                curNode = strNodeMap.get(str);
                curNode.times++;
                preIndex = nodeIndexMap.get(curNode);
            }
            if(preIndex == -1) {
                if (heapSize == heap.length) {
                    if (heap[0].times < curNode.times) {
                       nodeIndexMap.put(heap[0], -1);
                       nodeIndexMap.put(curNode, 0);
                       heap[0] = curNode;
                       heapify(0, heapSize);
                    }
                }
                else {
                    nodeIndexMap.put(curNode, heapSize);
                    heap[heapSize] = curNode;
                    heapInsert(heapSize++);
                }
            }
            else {
                heapify(preIndex, heapSize);
            }
        }

        public void heapInsert(int index) {
            while (index != 0) {
                int parent = (index - 1) / 2;
                if (heap[index].times < heap[parent].times) {
                    swap(index, parent);
                }
                else {
                    break;
                }
            }
        }

        public void heapify(int index, int heapSize) {
            int l = index * 2 + 1;
            int r = index * 2 + 2;
            while (l + 1 < heapSize) {
                int smallest = heap[l].times < heap[r].times ? l : r;
                if (heap[index].times > heap[smallest].times) {
                    swap(index, smallest);
                }
                else {
                    break;
                }
                index = smallest;
                l = 2 * index + 1;
            }
        }


        public void swap(int a, int b) {
            int temp = heap[a].times;
            heap[a].times = heap[b].times;
            heap[b].times = temp;
        }
    }




}
