package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/13 22:41
 */
public class LeetCode1039 {

    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        for (int len = 3; len <= n; len++) {
            for (int l = 0; l + len - 1 < n; l++) {
                int r = l + len - 1;
                dp[l][r] = Integer.MAX_VALUE;
                for (int k = l + 1; k < r; k++) {
                    dp[l][r] = Math.min(dp[l][r], dp[l][k] + dp[k][r] + values[l] * values[r] * values[k]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
