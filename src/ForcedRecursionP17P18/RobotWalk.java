package ForcedRecursionP17P18;

public class RobotWalk {
    public static int walkWays(int N, int E, int K, int S) {
        // 题目视频讲解见https://www.bilibili.com/video/BV13g41157hK/?p=17&spm_id_from=pageDriver&vd_source=d67679eb2bbd122f6cd7f6d142b724f3
        return f(N, E, K, S);
    }
    // 一共是1-N这么多位置 固定参数
    // 最终的目标是E 固定参数
    // 还剩rest步要走
    // 当前在cur位置
    // 返回方法数
    // 时间复杂度 O(2^k)
    public static int f(int N, int E, int rest, int cur) {
        if (rest == 0) {
            return cur == E ? 1 : 0;
        }
        if (cur == 1) {
            return f(N, E, rest - 1, cur + 1);
        }
        if (cur == N) {
            return f(N, E, rest - 1, cur - 1);
        }
        // 不属于以上三种情况，机器人在中间位置
        return f(N, E, rest -1, cur + 1) + f(N, E, rest - 1, cur - 1);
    }

    // 优化后的算法：计划搜索，用一个数组作为缓存，减去重复运算
    public static int walkWays1(int N, int E, int K, int S) {
        int[][] dp = new int[K + 1][N + 1];
        for (int i = 0; i <= K; i++) {
            for (int j = 0; j <= N; j++) {
                dp[i][j] = -1;
            }
        }
        return f1(N, E, K, S, dp);
    }

    // 以下是我写的
//    public static int f1(int N, int E, int rest, int cur, int[][] dp) {
//        if (dp[rest][cur] != -1) {
//            return dp[rest][cur];
//        }
//        else if (rest == 0) {
//            dp[rest][cur] = cur == E ? 1 : 0;
//            return dp[rest][cur];
//        }
//        else if (cur == 1) {
//            dp[rest][cur] = f1(N, E, rest - 1, 2 /*cur + 1*/, dp); // 这里 2 = cur + 1;;
//        }
//        else if (cur == N) {
//            dp[rest][cur] = return f1(N, E, rest - 1, N - 1/*cur - 1*/, dp);
//        }
//        return f1(N, E, rest - 1, cur - 1, dp) + f1(N, E, rest - 1, cur + 1, dp);
//    }

    // 以下是视频里的, 时间复杂度 O(K * N), 即为dp数组的大小
    public static int f1(int N, int E, int rest, int cur, int[][] dp) {
        // 视频讲解见https://www.bilibili.com/video/BV13g41157hK/?p=17&spm_id_from=pageDriver&vd_source=d67679eb2bbd122f6cd7f6d142b724f3第40min
        if (dp[rest][cur] != -1) {
            return dp[rest][cur];
        }
        else if (rest == 0) {
            dp[rest][cur] = cur == E ? 1 : 0;
            return dp[rest][cur];
        }
        else if (cur == 1) {
            dp[rest][cur] = f(N, E, rest - 1, 2);
        }
        else if (cur == N) {
            dp[rest][cur] = f(N, E, rest - 1, N - 1/*cur - 1*/);
        }
        else {
            dp[rest][cur] = f(N, E, rest - 1, cur - 1) + f(N, E, rest - 1, cur + 1);
        }
        return dp[rest][cur];
    }
}
