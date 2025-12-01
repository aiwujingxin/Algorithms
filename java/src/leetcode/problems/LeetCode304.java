package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/7 17:47
 * @description 容斥原理, 可扩展3维
 */
public class LeetCode304 {

    static class NumMatrix {

        int[][] s;

        public NumMatrix(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            s = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    s[i][j] = s[i][j - 1] + s[i - 1][j] - s[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int r1, int c1, int r2, int c2) {
            return s[r2 + 1][c2 + 1] - s[r1][c2 + 1] - s[r2 + 1][c1] + s[r1][c1];
        }
    }
}
