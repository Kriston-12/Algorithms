package ForcedRecursionP17P18;

public class CoinsMin {
    // 你有一个数组，数组中有不同面值的银币。现在要凑成aim元钱，问你最少需要几枚银币。
    // 视频讲解见https://www.bilibili.com/video/BV13g41157hK/?p=17&spm_id_from=pageDriver&vd_source=d67679eb2bbd122f6cd7f6d142b724f3
    // 我个人觉得radix sort加上two finger会更简单
    public static int CoinsMin(int[] arr, int aim) {
        return process(arr, 0, aim);
    }

    public static int process(int [] arr, int index, int rest) {
        if (rest == 0) {
            return 0;
        }
        if (index == arr.length) {
            return -1;
        }
        if (rest < 0) {
            return -1;
        }
            int take = process(arr, index + 1, rest - arr[index]);
            int noTake = process(arr, index + 1, rest);
            if (take == -1 && noTake == -1) {
                return -1;
            }
            else if (take == -1) {
                return noTake;
            }
            else if (noTake == -1) {
                return 1 + take;
            }
            else {
                return Math.min(1 + take, noTake);
            }

    }

    // 以下是计划搜索的优化
    public static int CoinsMin2(int[] arr, int aim) {
        int[][] dp = new int[arr.length + 1][aim + 1];   // length+1 是因为判断index的时候会取到length位置， aim + 1没太懂；
        for (int i = 0; i <= arr.length; i++) {
            for (int j = 0; j <= aim; j++) {
                dp[i][j] = -2;
            }
        }
        return process2(arr, 0, aim, dp);
    }

    public static int process2(int[] arr, int index, int rest, int[][] dp) {
        if (dp[index][rest] != -2) {
            return dp[index][rest];
        }
        if (rest == 0) {
            dp[index][rest] = 0;
            return 0;
        }
        else if (rest < 0) {
            dp[index][rest] = -1;
        }
        else if (index == arr.length) {
            dp[index][rest] = -1;
        }
        else {
            int take = process2(arr, index + 1, rest - arr[index], dp);
            int noTake = process2(arr, index + 1, rest, dp);
            if (take == -1 && noTake == -1) {
                dp[index][rest] = -1;
            }
            else {
                if (take == -1) {
                    dp[index][rest] = noTake;
                }
                else if (noTake == -1){
                    dp[index][rest] = 1 + take;
                }
                else {
                    dp[index][rest] = Math.min(take + 1, noTake);
                }
            }
        }
        return dp[index][rest];
    }

    // 这个方法是用来打印dp数组的
    public static void minCoins3(int[] arr, int aim) {
        int[][] dp = new int[arr.length + 1][aim + 1];
        for (int i = 0; i <= arr.length; i++) {  //col = 0的位置表示还没有开始取硬币，所以是0
            dp[i][0] = 0;
        }
        for (int j = 0; j <= aim; j++) {
            dp[arr.length][j] = -1;         // 已经越过了index边界length-1，方法无效，所以是-1
        }
        for (int index = arr.length - 1; index >= 0; index--) {
            for (int rest = 1; rest <= aim; rest++) {
                int noTake = dp[index + 1][rest];
                int take = -1;      // 可能会越界，在这里做判断
                if (rest - arr[index] >= 0) {
                    take = dp[index + 1][rest - arr[index]];
                }
                if (take == 0 && noTake == 0) {
                    dp[index][rest] = 0;
                }
                else {
                    if (take == 0) {
                        dp[index][rest] = noTake;
                    }
                    else if (noTake == 0) {
                        dp[index][rest] = take + 1;
                    }
                    else {
                        dp[index][rest] = Math.min(take + 1, noTake);
                    }
                }
            }
        }
    }
    }
