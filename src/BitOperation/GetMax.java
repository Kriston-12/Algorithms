package BitOperation;

// 题目: 给定两个有符号的32位整数a和b，返回a和b中较大的。【要求】不要用任何比较判断
public class GetMax {
    // n必须是0或者1
    public static int flip(int n) {
        return n^1;
    }

    public static int sign(int n) {
        return flip((n >> 31) & 1); // 取到n的符号位，如果此位是1(negative), return 0, otherwise return 1;
    }

    public static int getMax1(int a, int b) {
        int c = a - b;          // 注意：c有可能溢出(如果a是一个很大的正数而b是一个很负的复数）
        int sign = sign(c);
        int otherSign = flip(sign);
        return a * sign + b * otherSign;
    }

    // 以下是考虑到溢出的getMax
    public static int getMax2(int a, int b) {
        int c = a - b;
        int signA = sign(a);
        int signB = sign(b);
        int signC = sign(c);
        int difSign = signA ^ signB;  //  ^是异或运算符
        int samSign = flip(difSign);
        int returnA = difSign * signA + samSign * signC;
        int returnB = flip(returnA);
        return a * returnA + b * returnB;
    }
}
