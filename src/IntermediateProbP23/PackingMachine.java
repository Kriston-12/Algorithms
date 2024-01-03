package IntermediateProbP23;

// 视频见https://www.bilibili.com/video/BV13g41157hK?p=23&vd_source=d67679eb2bbd122f6cd7f6d142b724f3， 第20分钟
public class PackingMachine {
    public static int minOp(int[] arr) {
        if (arr == null || arr.length < 1) {
            return -1;
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum % arr.length != 0) {
            return -1;
        }
        int ans = 0;
        int avg = sum / arr.length;
        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int leftRest = leftSum - i * avg;
            int rightRest = sum - leftSum - arr[i] - (arr.length - i - 1) * avg;
            if (leftRest < 0 && rightRest < 0) {
                ans = Math.max(ans, Math.abs(leftRest) + Math.abs(rightRest));
            }
            else {
                ans = Math.max(Math.max(leftRest, rightRest), ans);
            }
            leftSum += arr[i];
        }
        return ans;
    }

}
