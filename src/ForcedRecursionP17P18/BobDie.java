package ForcedRecursionP17P18;

// 题目：现在有一个 N*M 的生存区域，bob一旦走出这个区域就无法生存。bob从row，col位置出发，需要走k步，问bob走完k步的生存概率是多少
public class BobDie {
    public static int live(int N, int M, int row, int col, int rest) {
        if (row < 0 || row >= N || col < 0 || col >= M) {
            return 0;
        }
        if (rest == 0) {
            return 1;
        }
        int point = 0;
        point += live(N, M, row + 1, col, rest - 1);
        point += live(N, M, row - 1, col, rest - 1);
        point += live(N, M, row, col + 1, rest - 1);
        point += live(N, M, row, col - 1, rest - 1);
        return point;
    }

    public static long gcd(long M, long N) {  // here M >= N
        return N == 0 ? M : gcd(N, M % N);
    }

    public static String bob1(int N, int M, int i, int j, int K) {  // K 代表可以走的步数
        long all = (long) Math.pow(4, K); // 每一步有上下左右四种走法，共有K^4钟走法
        long live = live(N, M, i, j, K);
        long gcd = gcd(all, live);
        return String.valueOf((live / gcd) + "/" + (all / gcd));  // 输出分数形式
    }

    public static int dpWays(int N, int M, int K, int n, int m, int k) {  //N*M是区域大小， n, m是出发
        int[][][] dp = new int[N + 1][M + 1][K + 1];
        dp[n][m][0] = 1;
        for (int row = 0; row <= N; row++) {
            for (int col = 0; col <= M; col++) {
                for (int h = 1; h <= K; h++) {
                    dp[row][col][h] += getValue(dp,row - 1, col, h - 1, N, M);
                    dp[row][col][h] += getValue(dp,row + 1, col, h - 1, N, M);
                    dp[row][col][h] += getValue(dp,row, col - 1, h - 1, N, M);
                    dp[row][col][h] += getValue(dp,row, col + 1, h - 1, N, M);
                }
            }
        }
        return dp[n][m][k];
    }

    public static int getValue(int[][][] dp, int n, int m, int k, int N, int M) {
        if (n < 0 || n >= N || m < 0 || m >= M) {
            return 0;
        }
        return dp[n][m][k];
    }

    public static void main(String[] args) {
        System.out.println(String.valueOf(24 / 8 + "/" + 64 / 8)); // 3 / 8
    }
}
