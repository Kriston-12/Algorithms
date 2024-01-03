package IntermediateProbP21P22;
// video explanation see https://www.bilibili.com/video/BV13g41157hK?p=21&vd_source=d67679eb2bbd122f6cd7f6d142b724f3, first 7 min
public class UniqueBT {
    // 递归法
    public static int process(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int res = 0;
        for (int leftNum = 0; leftNum <= n - 1; leftNum++) {   // i表示头节点左子树的节点个数
            int leftWays = process(leftNum);
            int rightWays = process(n - 1 - leftNum);
            res += leftWays * rightWays;
        }
        return res;
    }

    // dp法
    public static int process1(int n) {
        if (n < 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i < n + 1; i++) {  // 节点数为i的时候
            for (int j = 0; j < i ; j++) {   // 左侧节点数为j, 右侧为i - j - 1
                dp[i] = dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
