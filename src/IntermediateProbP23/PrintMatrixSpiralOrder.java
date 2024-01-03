package IntermediateProbP23;

// 视频见：https://www.bilibili.com/video/BV13g41157hK?p=23&vd_source=d67679eb2bbd122f6cd7f6d142b724f3第20分钟
public class PrintMatrixSpiralOrder {
    public static void print(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int sR = 0;                 // s represents start, R represents row
        int eR = matrix.length - 1; // e represents end
        int sC = 0;
        int eC = matrix[0].length - 1;
        while (sR <= eR && sC <= eC) {
            process(matrix, sR++, sC++, eR--, eC--);
        }
    }

    public static void process(int[][] matrix, int sR, int sC, int eR, int eC) {
        if (sR == eR) {
            for (int i = sC; i <= eC; i++) {
                System.out.print(matrix[sR][i]);
            }
        }
        else if (sC == eC) {                // 如果没有这个else边长为奇数矩阵的中心元素会被重复打印
            for (int j = sR; j <= eR; j++) {
                System.out.println(matrix[j][sC]);
            }
        }
        else {
            int curR = sR;
            int curC = sC;
            while (curC != eC) {
                System.out.println(matrix[sR][curC]);
                curC++;
            }
            while (curR != eR) {
                System.out.println(matrix[curR][eC]);
                curR++;
            }
            while (curC != sC) {
                System.out.println(matrix[eR][curC]);
                curC--;
            }
            while (curR != sR) {
                System.out.println(matrix[curR][sC]);
                curR--;
            }
        }
    }
}
