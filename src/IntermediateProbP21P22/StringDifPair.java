package IntermediateProbP21P22;

import java.util.HashSet;
import java.util.Set;

// 给定一个数组nums，求差值为k的去重数字对。
// Eg: [3, 2, 5, 7, 0], k = 2. [0, 2], [3, 5], [5, 7]
public class StringDifPair {
    //使用HashSet。使用两个HashSet，同样分为两种情况：k等于0和K不等于0。
    //如果k等于0时，对数组进行遍历，如果当前元素不存在于set1中，就添加进set1，如果存在set1中，就去判断是否存在于set2中，如果不存在，次数就加1，并将元素添加进set2中。
    //如果k不等于0，遍历数组，将当前元素添加进set1，将当前元素加上k后再添加进set2，然后使用retainAll方法，将set1中不包含set2元素的元素剔除掉（也就是两set的交集），最后count等于set1中元素的个数。
    public int findPairs4(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return 0;
        }
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        int count = 0;
        if (k == 0) {
            for (int n : nums) {
                if (!set1.contains(n)) {
                    set1.add(n);
                } else {
                    if (!set2.contains(n)){
                        count++;
                    }
                    set2.add(n);
                }
            }
        } else {
            for (int n : nums) {
                set1.add(n);
                set2.add(n + k);
            }
            set1.retainAll(set2);
            count = set1.size();
        }
        return count;
    }
}
