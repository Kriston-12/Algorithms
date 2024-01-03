package Sort;

public class RadixSort {
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        radixSortProcess(arr, 0, arr.length, maxBits(arr, 0, arr.length));
    }
    
    public static int maxBits(int[] arr, int l, int r) {
        int res = Integer.MIN_VALUE;
        for (int i = l; i < r; i++) {
            res = Math.max(res, arr[i]);
        }
        int dig = 0;
        while (res != 0) {
            res /= 10;
            dig++;
        }
        return dig;
    }
    public static void radixSortProcess(int[] arr, int l, int r, int dig) {
        final int radix = 10; // 0 - 9共10中digit数
        int[] bucket = new int[r - l + 1];
        int maxBit = maxBits(arr, l, r);
        for (int i = 0; i < maxBit; i++) {
            int[] count = new int[radix];
            for (int k = l; k < r; k++) {
                count[getBit(arr[k], i)]++;
            }
            for (int k = 1; k < radix; k++) {
                count[k] = count[k] + count[k - 1];
            }
            for (int k = r; k > l; k--) {
                int j = getBit(arr[k], i);
                bucket[count[j] - 1] = arr[k];
                count[j]--;
            }
            for (int j = l, k = 0; j < r; j++, k++) {
                arr[j] = bucket[k];
            }
        }
    }

    public static int getBit(int n, int digit) {
        int num = 1;
        for (int i = 0; i < digit; i++) {
            num *= 10;
        }
        return (n / (num)) % 10;
    }
}

