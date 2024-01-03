package IntermediateProbP23;

public class ZigZagPrintMatrix {
    public static void zigZag(int[][] matrix) {
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        int aR = 0;     //需要两个点， aR，aC表示a的ROW和a的COl bR，bC表示b的ROW和a的COl
        int aC = 0;
        int bR = 0;
        int bC = 0;
        boolean fromUp = false;       // 用来控制打印的方向
        while (aR != endR + 1) {
            printLevel(matrix, aR, aC, bR, bC, fromUp);
            aR = aC == endC ? aR : aR + 1;
            aC = aC == endC ? aC : aC + 1;
            bR = bR == endR ? bR : bR + 1;
            bC = bR == endR ? bC + 1 : bC;
            fromUp = !fromUp;
        }
    }

    public static void printLevel(int[][] matrix, int aR, int aC, int bR, int bC, boolean dir) {
        if (dir) {
            while (aR != bR + 1) {
                System.out.print(matrix[aR--][aC--] + " ");
            }
        }
        else {
            while (bR != aR - 1) {
                System.out.println(matrix[bR--][bC++] + " ");
            }
        }
    }
}
