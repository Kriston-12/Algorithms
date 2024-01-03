package IntermediateProblemP20___;
// 当前有一对牛马，他们都绝顶聪明。现在有n堆草，
// 这对牛马每次都只能吃4^i(i = 0, 1...n)堆草，
// 问如果他们如何稳赢(恰好吃完即为获胜条件）

public class EatGrass {
    public static String winner1(int n) {
        // 0   1   2   3   4   // 这里是回合数
        // S   F   S   F   F   // F stands for first, S stands for subsequent
        if (n < 5) {
            return (n == 0 || n == 2) ? "subsequent" : "first";
        }
        // when n >= 5
        int base = 1; // 先手决定吃的堆数
        while (base <= n) {
            if (winner1(n - base).equals("subsequent")) {
                return "first";
            }
            if (base > n / 4) {     // 防止整数溢出
                break;
            }
            base *= 4;
        }
        return "subsequent";
    }


    // 数学归纳法
    public static String winner(int n) {
        if (n % 5 == 0 || n % 5 == 2) {
            return "subsequent";
        }
        return "first";
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            System.out.println(i + " : " + winner1(i));
        }
    }
}
