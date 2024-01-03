package OrderedListAndDisjointedSet;

public class Island {

    public static int countIsland(int[][] m) { // 时间复杂度是O(M*N) 基础算法
        if (m == null || m[0] == null) {  //这里m[0] == null 不是很懂
            return 0;
        }
        int N = m.length;
        int M = m[0].length;
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (m[i][j] == 1) {
                    res++;
                    infect(m, i, j, N, M);
                }
            }
        }
        return res;
    }

    public static void infect(int[][] m, int i, int j, int N, int M) {
        if (i < 0 || i >= M || j < 0 || j > N || m[i][j] != 1) {
            return;
        }
        // m[i][j] 不为1
        m[i][j] = 2;
        infect(m, i + 1, j, N, M);
        infect(m, i - 1, j, N, M);
        infect(m, i, j + 1, N, M);
        infect(m, i, j - 1, N, M);
    }
}
