package IntermediateProbP21P22;

public class ParenthesisMaxLength {
    // 以下是我的代码
    public static int ParenthesisMaxLength(String str) {
        int[] dp = new int[str.length()];
        int res = 0;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                dp[i] = 0;
            }
            else {
                dp[i] = dp[i - dp[i - 1] - 1] == '(' ? (2 + dp[i - 1]) + (((i - dp[i - 1] - 2) >= 0) ? dp[i - dp[i - 1] - 2]: 0) : 0;
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // 以下是视频里的代码
    public static int maxLength(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        int[] dp = new int[str.length()];
        int res = 0;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ')') {
                int pre = i - dp[i - 1] - 1;
                if (pre >= 0 && str.charAt(pre) == '(') {
                    dp[i] += 2 + dp[i - 1] + ((pre - 1 >= 0) ? dp[pre - 1] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
