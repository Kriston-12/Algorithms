package GreedyAlgorithm;

public class NQueens {
    public static int num1(int n) {
        if (n < 1) {
            return 0;
        }
        int[] record = new int[n];   // record[i] means i 行的皇后放在了record[i] 列
        return process(0, record, n);
    }


    //目前来到了第i行
    //record[0.....i-1] 表示之前i-1行所放皇后的列位置
    //n代表所有的行数
    //返回摆完所有的皇后，一共有多少摆法
    public static int process(int i, int[] record, int n) {
        if (i == n) {   // i 已经到达最后一行，直接返回
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {    // 对每个列进行判断
            if(isValid(record, i, j)) {  // 判断i行第j列是否valid
                record[i] = j;          // 如果valid，那么第i行排放第j列
                res += process(i + 1, record, n);
            }
        }
        return res;
    }

    public static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {   // 遍历行数，判断之前的行有没有和当先j列同行同列或者同斜线
            if (record[k] == j && Math.abs(record[k] - j) == Math.abs(i - k)) {  // 斜率为1 行差的绝对值不能等于列差的绝对值
                return false;
            }
        }
        return true;
    }

    // method 2 faster, 常数级优化, 只能处理小于32皇后问题
    public static int num2(int n) {
        if (n < 1 || n > 32) {
            return 0;
        }
        int limit = n == 32 ? 1 : (1 << n) - 1; //生成一个32位后面n位为1，前面32-n位为0的数
        return process2(limit, 0, 0, 0);
    }

    // col---列的限制， leftDiaLim---左对角线的限制， rightDiaLim---右对角线的限制
    public static int process2(int limit, int colLim, int leftDiaLim, int rightDiaLim) {
        if (colLim == limit) {  // 列限制为所有二进制位为1，即所有位都有皇后了，证明获得一个解
            return 1;
        }
        // pos二进制位为0的位表现了所有候选皇后的位置
        int pos = limit & (~(colLim | leftDiaLim | rightDiaLim));  // 按位或，路径图2有讲解

        int mostRightOne = 0;

        int res = 0;
        while (pos != 0) { // while是从右到左循环提取1的过程----00000001， 00000010， 00000100 .... 10000000, 00000000
            mostRightOne = pos & (~pos + 1); // 把最有册的1提取出来
            pos = pos - mostRightOne;
            res += process2(limit, colLim | mostRightOne, (leftDiaLim | mostRightOne) << 1,
                    (rightDiaLim | mostRightOne) >> 1);
        }
        return res;
    }


}
