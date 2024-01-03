package ForcedRecursionP17P18;

// 你现在要设计一个方法，让中国象棋中的马从（0，0）位置跳到指定的x，y位置并且必须跳step步，问有多少种跳法. 中国象棋的棋盘为横9竖10
public class HorseJump {
    public static int process(int x, int y, int restStep) {
        if (x < 0 || x > 8 || y < 0 || y > 9) {
            return 0;
        }
        if (restStep == 0) {
            return (x == 0 && y == 0) ? 1 : 0;
        }
        return process(x - 1, y - 2, restStep - 1) +
                process(x - 1, y + 2, restStep - 1) +
                process(x + 1, y - 2, restStep - 1) +
                process(x + 1, y + 2, restStep - 1) +
                process(x - 2, y + 1, restStep - 1) +
                process(x - 2, y - 1, restStep - 1) +
                process(x + 2, y + 1, restStep - 1) +
                process(x + 2, y - 1, restStep - 1);
    }

    public static int dpWays(int x, int y, int step) {
        int[][][] dp = new int[9][10][step + 1];  // 0 到 step共有step + 1层
        dp[0][0][0] = 1;
        for (int h = 1; h <= step; h++) {
            for (int r = 0; r < 9; r++) {
                for (int c = 0; c < 10 ; c++) {      // 层之间是独立关系，不会互相影响，所以 int c = 9; c >= 0; c-- 也是对的
                    dp[r][c][h] += getValue(r - 1, c - 2, h - 1, dp);
                    dp[r][c][h] += getValue(r - 1, c + 2, h - 1, dp);
                    dp[r][c][h] += getValue(r + 1, c - 2, h - 1, dp);
                    dp[r][c][h] += getValue(r + 1, c + 2, h - 1, dp);
                    dp[r][c][h] += getValue(r - 2, c - 1, h - 1, dp);
                    dp[r][c][h] += getValue(r - 2, c + 1, h - 1, dp);
                    dp[r][c][h] += getValue(r + 2, c - 1, h - 1, dp);
                    dp[r][c][h] += getValue(r + 2, c + 1, h - 1, dp);
                }
            }
        }
        return dp[x][y][step];
    }

    public static int getValue(int x, int y, int step, int[][][] dp) {
        if (x < 0 || x > 8 || y < 0 || y > 9) {
            return 0;
        }
        return dp[x][y][step];
    }

    public static void main(String[] args) {
        int x = 7;
        int y = 7;
        int step = 10;
        System.out.println(process(x, y, step));
        System.out.println(dpWays(x, y, step));
    }
}
