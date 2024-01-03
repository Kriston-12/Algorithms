package ForcedRecursionP17P18;
// arr里都是正数，没有重复值，每一个值代表一种纸质货币，每一种都可以用无线张
// 最终要用这些货币找零，找零的数值为aim
// 求找零方法数并且返回
public class CoinsWay {
    public static int way1(int[] arr, int aim) {
        return process(arr, aim, 0);
    }

    public static int process(int[] arr, int aim, int index) {
        if (index == arr.length - 1) {
            return aim == 0 ? 1 : 0;
        }
        int ways = 0;
        for (int num = 0; num * arr[index] <= aim; num++) {
            ways += process(arr, aim - num * arr[index], index + 1);
        }
        return ways;
    }

    // 第一次优化，还是会有重复计算
    public static int dpWay1(int[] arr, int aim) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int N = arr.length + 1;
        int[][] dp = new int[N][aim + 1];
        dp[N][0] = 1;
        for (int i = N - 1; i >= 0; i--) {  // 第N行填好了所以从N-1行开始填
            for (int j = 0; j <= aim; j++) {
                int ways = 0;
                for (int num = 0; num * arr[i] <= aim; num++) {
                    ways += dp[i + 1][j - arr[i] * num];
                }
                dp[i][j] = ways;
            }
        }
        return dp[0][aim];
    }

    // 第二此优化，去掉一个for loop减少重复计算
    public static int dpWay2(int[] arr, int aim) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int N = arr.length + 1;
        int[][] dp = new int[N][aim + 1];
        dp[N][0] = 1;
        for (int i = N - 1; i >= 0; i--) {  // 第N行填好了所以从N-1行开始填
            for (int rest = 0; rest <= aim; rest++) {
                    dp[i][rest] = dp[i + 1][rest];
                    if (rest - arr[i] >= 0) {
                        dp[i][rest] += dp[i][rest - arr[i]];
                    }
            }
        }
        return dp[0][aim];
    }

}
