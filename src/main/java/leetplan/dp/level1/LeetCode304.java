package leetplan.dp.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/18 23:34
 * <a href="https://leetcode.com/problems/range-sum-query-2d-immutable/discuss/2104317/DP-Visualised-%2B-Interview-Tips">...</a>
 */
public class LeetCode304 {


    class NumMatrix {

        private int[][] sums;

        public NumMatrix(int[][] matrix) {
            int n = matrix.length;
            int m = matrix[0].length;
            sums = new int[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    sums[i][j] = sums[i - 1][j] + sums[i][j - 1] + matrix[i - 1][j - 1] - sums[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sums[row2 + 1][col2 + 1] - (sums[row1][col2 + 1] + sums[row2 + 1][col1]) + sums[row1][col1];
        }
    }
}
