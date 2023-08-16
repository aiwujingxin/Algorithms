package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/23 20:07
 * <a href="https://leetcode.com/problems/minimum-cost-to-merge-stones/solutions/247657/JAVA-Bottom-Up-+-Top-Down-DP-With-Explaination/">...</a>
 */
public class LeetCode1000_dp_2d {

    public int mergeStones(int[] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }
        int n = stones.length;
        int[][] dp = new int[n + 1][n + 1];
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + stones[i - 1];
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i + len - 1 <= n; i++) {
                int l = i;
                int r = i + len - 1;
                dp[l][r] = Integer.MAX_VALUE;
                for (int k = l; k < r; k++) {
                    dp[l][r] = Math.min(dp[l][r], dp[l][k] + dp[k + 1][r]);
                }
                dp[l][r] += prefixSum[r] - prefixSum[l - 1];
            }
        }
        return dp[1][n];
    }
}
