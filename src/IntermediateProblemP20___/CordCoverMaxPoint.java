package IntermediateProblemP20___;
// 给定一个有序arr，代表数轴上从左到右有n个点arr[0], arr[1]....arr[n - 1],             arr[i] 代表第i个点所在的位置
// 给定一个正数L，代表一根长度为L的绳子，求绳子覆盖的点
// 视频见https://www.bilibili.com/video/BV13g41157hK?p=20&vd_source=d67679eb2bbd122f6cd7f6d142b724f3 10 - 20min
public class CordCoverMaxPoint {

    public static int CordCoverMaxPoint(int[] arr, int l) {
        if (arr == null || arr.length < 1 || l < 1) {
            return 0;
        }
        return process(arr, l);
    }

    // Sliding Windows O(n)
    public static int process(int[] arr, int l) {
        int count = 1;
        int max = 0;
        int right = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            count = 1;
            while (right < arr.length && arr[right] - arr[i] <= l) {
                right++;
            }
            count += right - i;
            if (max < count) {
                max = count;
            }
        }
        return max;
    }
}
