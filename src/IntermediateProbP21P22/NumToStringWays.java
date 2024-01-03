package IntermediateProbP21P22;

// 视频见 https://www.bilibili.com/video/BV13g41157hK/?p=22&spm_id_from=pageDriver&vd_source=d67679eb2bbd122f6cd7f6d142b724f3 第32分钟
public class NumToStringWays {
    public static int numToStringWays(int num) { //
        if (num < 1) {
            return 0;
        }
        return process(String.valueOf(num).toCharArray(), 0);
    }

    // Recursion Method
    public static int process(char[] s, int index) {
        if (index == s.length) {
            return 1;
        }
        if (s[index] == '0') {
            return 0;
        }
        int res = process(s, index + 1);    // 做了一个决定，选择字符s[index]本身转换为字母
        if (index == s.length - 1) {
            return res;
        }
        if (((s[index] - '0') * 10 + s[index + 1]) < 27) {
            res += process(s, index + 2);
        }
        return res;
    }

    public static int dpWays(int num) {
        if (num < 1) {
            return 0;
        }
        char[] s = String.valueOf(num).toCharArray();
        int N = s.length;
        int[] dp = new int[N + 1];
        dp[N] = 1;
        dp[N - 1] = s[N - 1] == '0' ? 0 : 1;
        for (int i = N - 2; i >= 0; i--) {
            if (s[i] == '0') {
                dp[i] = 0;
            }
            else {
                dp[i] = dp[i + 1] + ((s[i] * 10 + s[i + 1] < 27) ? dp[i + 2] : 0);
            }
        }
        return dp[0];
    }
}
