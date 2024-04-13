package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/13 22:41
 */
public class LeetCode1039 {

    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        for (int r = 3; r <= n; r++) {
            for (int i = 0; i < n - r + 1; i++) {
                int j = i + r - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + values[i] * values[j] * values[k]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
