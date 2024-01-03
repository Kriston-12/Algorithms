package Sort;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapTest {

    public static class AComp implements Comparator<Integer>{

        // 如果返回负数， 认为第一个参数应该放在上面
        // 如果返回正数， 认为第二个参数应该放在上面
        // 如果返回0， 都可
        public int compare(Integer arg0, Integer arg1) {
            return arg1 - arg0;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(new AComp()); // 默认小分堆， 加上new AComp后大分堆
        heap.add(10);
        heap.add(20);
        heap.add(5);
        heap.add(39);
        while (!heap.isEmpty()) {
            System.out.println(heap.poll());
        }
    }
}
