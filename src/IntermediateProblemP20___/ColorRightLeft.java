package IntermediateProblemP20___;

public class ColorRightLeft {
    // 你有一个spectrum String s = "RRGBGGB...", R represents red, G represents green. 这个spectrum的i位置左侧必须都是G，右侧必须都是R。
    // i位置为0, 1, 2....s.length - 1, 问左右侧一共染色多少次才能让i位置左侧必须都是G，右侧必须都是R。
    public static int minPaintTest(String s) {
        char[] c  = s.toCharArray();
        int[] l = new int[c.length];    //记录左侧R的个数
        int[] r = new int[c.length];    //记录左侧G的个数
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 'R') {
                l[i]++;
            }
        }
        for (int i = c.length - 1; i >= 0; i++) {
            if (c[i] == 'G') {
                r[i]++;
            }
        }
        int res = 0;
        for (int i = 0; i < c.length; i++){
            res += l[i];
            res += r[i];
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
