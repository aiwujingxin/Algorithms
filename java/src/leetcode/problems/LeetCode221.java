package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/3 14:33
 */
public class LeetCode221 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // dp[i][j] 表示以 (i, j) 为右下角的最大正方形边长
        int[][] dp = new int[m][n];
        int maxSide = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 只有当前位置是 '1' 才有可能构成正方形
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        // 边界情况：第一行或第一列，最大只能是 1
                        dp[i][j] = 1;
                    } else {
                        // 核心递推：受限于左、上、左上的最小值（短板效应）
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }
}
