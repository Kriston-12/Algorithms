package Bitree;

public class 折纸问题 {
    // down means concave down == true, up means concave up == false
    // 子树的规律是左down右up
    public static void printProcess(int i, int n, boolean down) {
        if (i >= n) {
            return;
        }
        printProcess(i + 1, n, true);
        System.out.println(down ? "Down" : "Up");
        printProcess(i + 1, n, false);
    }
}
