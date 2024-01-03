package GreedyAlgorithm;

// 哈夫曼Huffman coding problem，
// Example：你有一根长为60的金条，你现在想把它分为三部分[10, 20, 30]，如果你先分为[10, 50]， costs ￥60，再把50 分为 20 和 30， costs 50， 共计￥110。
// 如果你先分为[30, 30]，costs ￥30. 再把其中一个30分为10和20， costs ￥30。共计60元；

import java.util.PriorityQueue;

public class LessMoneySplitGold {
    public static int lessMoney(int[] arr) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int j : arr) {
            pQ.add(j);
        }
        int sum = 0;
        int cur = 0;
        while(pQ.size() > 1) {
            cur += pQ.poll() + pQ.poll();
            sum += cur;
            pQ.add(cur);
        }
        return sum;
    }
}
