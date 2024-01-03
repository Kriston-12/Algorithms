package IntermediateProbP21P22;

import java.util.Arrays;
import java.util.HashSet;

// Video see https://www.bilibili.com/video/BV13g41157hK?p=21&vd_source=d67679eb2bbd122f6cd7f6d142b724f3 30min
public class MagicOp {
    // 请保证arr1中无重复值，arr2中无重复值，且arr1和arr2中一定有数字
    public static int magicOp(int[] arr1, int[] arr2) {
        double sum1 = 0;
        double sum2 = 0;
        for (int i : arr1) {
            sum1 += i;
        }
        for (int i : arr2) {
            sum2 += i;
        }
        int[] arrMore = null;
        int[] arrLess = null;
        double sumMore = 0;
        double sumLess = 0;
        if (avg(sum1, arr1.length) > avg(sum2, arr2.length)) {
            arrMore = arr1;
            arrLess = arr2;
            sumMore = sum1;
            sumLess = sum2;
        }
        else {
            arrMore = arr2;
            arrLess = arr1;
            sumMore = sum2;
            sumLess = sum1;
        }
        int ans = 0;
        Arrays.sort(arrMore);
        int sizeMore = arrMore.length;
        int sizeLess = arrLess.length;
        HashSet<Integer> lessSet = new HashSet<>();
        for (int i : arrLess) {
            lessSet.add(i);
        }
        for (int i = 0; i < sizeMore; i++) {
            double cur = (double) arrMore[i];   // 这里也可以不用double 和 cur
            if (cur < avg(sumMore, sizeMore) && cur > avg(sumLess, sizeLess) && !lessSet.contains(arrMore[i])) {
                ans++;
                sumMore -= cur;
                sizeMore--;
                sumLess += cur;
                sumLess++;
                lessSet.add(arrMore[i]);
            }
        }
        return ans;
    }

    public static double avg(double sum, int num) {
        return sum / num;
    }
}
