package IntermediateProbP23;
// 视频见 https://www.bilibili.com/video/BV13g41157hK?p=23&vd_source=d67679eb2bbd122f6cd7f6d142b724f3 第30分钟
public class RotateMatrix {
    public static void rotateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int sR= 0;
        int sC = 0;
        int eR = matrix.length;
        int eC = matrix[0].length;
        while (sR <= eR) {
            rotateEdge(matrix, sR++, sC++, eR--, eC--);
        }
    }

    public static void rotateEdge(int[][] matrix, int sR, int sC, int eR, int eC) {
        int dif = eR - sR;  // rDif 实际上等于 cDif因为matrix是square, 所以这里只用一个dif记录
        for (int i = 0; i <= dif; i++) {
            int temp = matrix[sR][sC + i];
            matrix[sR][sC + i] = matrix[eR + i][eC];
            matrix[sR + i][eC] = matrix[eR][eC - i];
            matrix[eR][eC - i] = matrix[eR - i][sC];
            matrix[eR - i][sC] = temp;
        }
    }
}
