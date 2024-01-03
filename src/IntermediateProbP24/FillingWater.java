package IntermediateProbP24;

// video explains see https://www.bilibili.com/video/BV13g41157hK/?p=24&spm_id_from=pageDriver&vd_source=d67679eb2bbd122f6cd7f6d142b724f3 40min
public class FillingWater {
    public static int fillingSum(int[] arr) {
        int maxL = arr[0];     // 左边遇到的最高的
        int maxR = arr[arr.length - 1];     // 右边遇到的最高的
        int left = 1;
        int right = arr.length - 2;  // double pointers
        int sum = 0;
        int i = right;
        while (left < right) {
            int lower = Math.min(maxL, maxR);
            int rest = Math.max(Math.min(maxL, maxR) - arr[i], 0);
            if (rest > 0) {
                sum += rest;
                if (i == left) {
                    left++;
                }
                if (i == right) {
                    right--;
                }
                if (lower == maxL) {
                    i = left;
                }
                if (lower == maxR) {
                    i = right;
                }
            }
            else {
                if (i == left) {
                    maxL = arr[i];
                    left++;
                    i = left;
                }
                if (i == right) {
                    maxR = arr[i];
                    right--;
                    i = right;
                }
            }
        }
        return sum;
    }
}
