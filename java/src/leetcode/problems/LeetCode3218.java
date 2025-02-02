package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 12/25/24 22:02
 */
public class LeetCode3218 {

    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        int[][][][] f = new int[m][n][m][n];
        for (int a = 0; a < m; a++) {
            for (int b = 0; b < n; b++) {
                for (int c = a; c >= 0; c--) {
                    for (int d = b; d >= 0; d--) {
                        if (c == a && d == b) {
                            continue;
                        }
                        f[a][b][c][d] = Integer.MAX_VALUE;
                        // 枚举横向切割线
                        for (int k = a; k > c; k--) {
                            f[a][b][c][d] = Math.min(f[a][b][c][d],
                                    f[a][b][k][d] + f[k - 1][b][c][d] + horizontalCut[k - 1]);
                        }
                        // 枚举纵向切割线
                        for (int k = b; k > d; k--) {
                            f[a][b][c][d] = Math.min(f[a][b][c][d],
                                    f[a][b][c][k] + f[a][k - 1][c][d] + verticalCut[k - 1]);
                        }
                    }
                }
            }
        }
        return f[0][0][m - 1][n - 1];
    }
}
