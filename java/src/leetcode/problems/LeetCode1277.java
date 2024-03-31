package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/30 12:50
 */
public class LeetCode1277 {

    public int countSquares(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int cnt = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0];
            if (matrix[i][0] == 1) {
                cnt++;
            }
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = matrix[0][i];
            if (matrix[0][i] == 1) {
                cnt++;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    cnt += dp[i][j];
                }
            }
        }
        return cnt;
    }
}
