package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/7 17:47
 */
public class LeetCode304 {

    class NumMatrix {

        private int[][] sums;

        public NumMatrix(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            sums = new int[m + 1][n + 1];

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    sums[i][j] = sums[i][j - 1] + matrix[i - 1][j - 1];
                }
            }
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    sums[i][j] += sums[i - 1][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row2 + 1][col1] + sums[row1][col1];
        }
    }
}
