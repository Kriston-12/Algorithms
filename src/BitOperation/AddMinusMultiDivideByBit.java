package BitOperation;

// 用位运算实现加减乘除操作，要求不能用算术运算符
public class AddMinusMultiDivideByBit {

    // 如果用户传入的参数，a + b就是溢出的，不对此进行考虑
    public static int add(int a, int b) {
        // 视频见https://www.bilibili.com/video/BV13g41157hK/?p=16&spm_id_from=pageDriver&vd_source=d67679eb2bbd122f6cd7f6d142b724f3，第一小时40分钟
        int sum = a;
        while (b != 0) {
            sum = a ^ b;        // 无进位相加的结果
            b = (a & b) << 1;   // 进位信息
            a = sum;
        }
        return sum;
    }

    public static int negNum(int n) { // 取相反数
        return add(~n, 1);
    }

    public static int minus(int a, int b) {
        return add(a, negNum(b));
    }

    // 乘法
    // 不考虑a*b溢出的情况
    public static int multiplication(int a, int b) { // 视频讲解见add中的链接第1小时50分
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                res = add(res, a);
            }
            a <<= 1;
            b >>= 1;
        }
        return res;
    }

    public static int division(int a, int b) {
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;
        int res = 0;
        for (int i = 31; i > -1; minus(i, 1)) {
            if ((x >> i) >= y) {
                res |= (1 << i);
                x = minus(x, y << i);
            }
        }
        return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
    }

    public static boolean isNeg(int n) {
        return n < 0;
    }

}
