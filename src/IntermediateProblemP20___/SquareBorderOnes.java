package IntermediateProblemP20___;

// 视频讲解见https://www.bilibili.com/video/BV13g41157hK/?p=20&spm_id_from=pageDriver&vd_source=d67679eb2bbd122f6cd7f6d142b724f3第1:33
public class SquareBorderOnes {
    public static int maxBorderOnes(int[][] m) {
        int M = m.length;
        int N = m[0].length;      // M x N 的矩阵

        int[][] contiRight = new int[M][N]; // contiRight[i][j] 记录的是m在(i,j)位置右边有多少个连续的1
        int[][] contiDown = new int[M][N];  // contiDown[i][j] 记录的是m在(i,j)位置下面有多少个连续的1

        int countRight = 0;
        int countDown = 0;
        // 先计算每一行右边有几个连续的1
        for (int i = 0; i < M; i++) {
            for (int j = N - 1; j >= 0; j--){
                if (m[i][j] == 1) {
                    contiRight[i][j] = ++countRight;
                }
                else {
                    contiRight[i][j] = 0;
                    countRight = 0;
                }
            }
        }
        // 计算每一列下面有几个连续的1，并用contiDown[i][j]记录
        for (int j = 0; j < N; j++) {
            for (int i = M - 1; i >= 0; i--) {
                if (m[i][j] == 1) {
                    contiDown[i][j] = ++countDown;
                }
                else {
                    contiDown[i][j] = 0;
                    countDown = 0;
                }
            }
        }
        int max = 0;
        int res = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (m[i][j] != 0) {
                    if (contiDown[i][j] == 1) {
                        res += 1;
                        break;
                    }
                    if (contiDown[i][j] == contiRight[i][j]) {
                        for (int k = contiDown[i][j]; k > 1; k--) {
                            if (contiDown[i + k][j] == contiRight[i][j + k]) {
                                res += k;
                                break;
                            }
                        }
                    }
                    if (max < res) {
                        max++;
                    }
                }
            }
        }
        return max;
    }
}
