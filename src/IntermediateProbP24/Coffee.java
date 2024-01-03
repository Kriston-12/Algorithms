package IntermediateProbP24;
import java.util.Comparator;
import java.util.PriorityQueue;

// video explains see https://www.bilibili.com/video/BV13g41157hK?p=24&vd_source=d67679eb2bbd122f6cd7f6d142b724f3 1:07
public class Coffee {
    public static class Machine {
        int timePoint;
        int workTime;
        public Machine(int tP, int wT) {
            timePoint = tP;
            workTime = wT;
        }
    }

    public static class MachineComparator implements Comparator<Machine> {
        public int compare(Machine o1, Machine o2) {
            return (o1.timePoint + o1.workTime) - (o2.timePoint + o2.workTime);
        }
    }
    // method 2
    public static int minTime(int[] arr, int n, int a, int b) {
        PriorityQueue<Machine> heap = new PriorityQueue<>(new MachineComparator());
        for (int i = 0; i < arr.length; i++) {
            heap.add(new Machine(0, arr[i]));
        }
        int[] drinks = new int[n];
        for (int i = 0; i < n; i++) {
            Machine cur = heap.poll();
            cur.timePoint += cur.workTime;
            drinks[i] = cur.timePoint;
            heap.add(cur);
        }
        return process(drinks, a, b, 0, 0);
    }
    // drinks[i] 代表第i个人喝完咖啡的时间，
    // 用coffee machine洗完一杯的时间是a，
    // 自然挥发干净的时间是b，
    // 当前来到第几个人开始洗杯子是index，washLine表示咖啡机什么时候有空
    public static int process(int[] drinks, int a, int b, int index, int washLine) {
        if (index == drinks.length - 1) {
            return Math.min((Math.max(drinks[index], washLine) + a), drinks[index] + b);
        }
        // wash是当前的咖啡杯，决定放在洗咖啡的机器里洗，什么时候洗完
        int wash = Math.max(drinks[index], washLine) + a;

        // 洗完剩下所有咖啡最早结束的时间
        int next1 = process(drinks, a, b, index + 1, wash);

        // 需要做完所有事情，所以包括我洗完的时间，和剩下咖啡机洗完的最早时间
        int p1 = Math.max(wash, next1);

        // 第二种可能性，决定当前的杯子挥发
        int dry = drinks[index] + b;
        int next2 = process(drinks, a, b, index + 1, washLine);
        int p2 = Math.max(dry, next2);
        return Math.min(p1, p2);
    }
}
