package GreedyAlgorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MakeMostMoneyBasedOnCostsAndProfits {
    public static class Node {
        public int p;   // p represents profits
        public int c;   // c represents costs

        public Node(int p, int c) {
            this.p = p;
            this.c = c;
        }

    }

    public static class MinCostComparator implements Comparator<Node> {
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c;
        }
    }

    public static class MaxCostComparator implements Comparator<Node> {
        public int compare(Node o1, Node o2) {
            return o2.c - o1.c;
        }
    }

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] costs) { // w represents 启动资金, k represents 最多选择项目的个数
        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxCostComparator());

        for (int i = 0; i < profits.length; i++) {
            minCostQ.add(new Node(profits[i], costs[i]));
        }
        for (int i = 0; i < k; i++) { // 进行k轮
            // 能力所及的项目，全解锁
            while(!minCostQ.isEmpty() && minCostQ.peek().c <= w) {
                maxProfitQ.add(minCostQ.poll());
            }
            if (maxProfitQ.isEmpty()) {
                return w;
            }
            w += maxProfitQ.poll().p;
        }
        return w;
    }

}
