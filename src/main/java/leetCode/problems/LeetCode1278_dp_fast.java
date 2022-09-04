package leetCode.problems;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/29 00:22
 */
public class LeetCode1278_dp_fast {

    public int palindromePartition(String s, int k) {
        int n = s.length();
        int[][] cost = new int[n][n];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                cost[i][j] = cost[i + 1][j - 1];
                if (s.charAt(i) != s.charAt(j)) {
                    cost[i][j]++;
                }
            }
        }
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][1] = cost[0][i - 1];
            for (int j = 2; j <= k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int t = j - 1; t < i; t++) {
                    dp[i][j] = Math.min(dp[i][j], dp[t][j - 1] + cost[t][i - 1]);
                }
            }
        }
        return dp[n][k];
    }
}
