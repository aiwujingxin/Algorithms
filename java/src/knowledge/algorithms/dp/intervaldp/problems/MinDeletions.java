package knowledge.algorithms.dp.intervaldp.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 7/6/25 23:53
 * @description 每次可以删除一个回文子序列 求 最少几次可以删光
 */
public class MinDeletions {

    public int minDeletions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                }
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
