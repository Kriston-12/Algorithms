package Sort;

public class Sparse_array {
    public static void main(String[] arg) {
        //创建一个原始的二维数组
        //0 表示没有棋子，1表示黑子 2表示蓝子

        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        //输出原始的二维数组
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        int sum = 0;
        for (int[] ints : chessArr1) {
            for (int j = 0; j < chessArr1.length; j++) {
                if (ints[j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println(sum);
            // create the corresponding sparse array
        int[][] sparseArr = new int[sum + 1][3];
        // assign value to sparseArr
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        int count = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }

            }
        }
        System.out.println();
        System.out.println("the sparse array is ");
        for (int i = 0; i < sparseArr.length; i++){
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }
        System.out.println();
    }
}