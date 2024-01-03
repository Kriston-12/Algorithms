package InterProbP25;

// video see https://www.bilibili.com/video/BV13g41157hK?p=25&spm_id_from=pageDriver&vd_source=d67679eb2bbd122f6cd7f6d142b724f3 第1分钟
public class FibonacciByMatrix {

    public static int fi(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int[][] m = {{1, 1}, {1, 0}};
        int[][] res = matrixPower(m, n - 2);
        return res[1][0] + res[0][0];
    }
    public static int[][] matrixPower(int[][] m, int p) {
        int[][] res = new int[m.length][m[0].length];
        for (int i = 0; i < res.length; i++) {
            res[i][i] = 1;
        }
        int[][] t = m;
        for (; p!= 0; p >>= 1) {
            if ((p & 1) != 0) {
                res = multiMatrix(res, t);
            }
            t = multiMatrix(t, t);
        }
        return res;
    }
    public static int[][] multiMatrix(int[][] m1, int[][] m2) {
        int[][] res = new int[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                for (int k = 0; k < m2.length; k++) {
                    res[i][j] += m1[i][k] * m2[j][k];
                }
            }
        }
        return res;
    }
}
