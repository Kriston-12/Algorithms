package InterProbP25;

public class FibonacciMatrixStrOneZero {
    public static int fi(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        if (arr.length == 1) {
            return 1;
        }
        if (arr.length == 2) {
            return 2;
        }
        int[][] m = {{1, 1},
                    {1, 0}};
        int[][] res = matrixPower(m, arr.length - 2);
        return res[0][0] + res[1][0];
    }

    public static int[][] matrixPower(int[][] m, int p) {
        int[][] res = new int[m.length][m[0].length];
        for (int i = 0; i < res.length; i++) {
            res[i][i] = 1;
        }
        int[][] t = m;
        for (; p > 0; p >>= 1) {
            if ((p & 1) == 1) {
                res = multiMatrix(t, res);
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
