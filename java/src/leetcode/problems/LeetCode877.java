package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/10 17:37
 * @see LeetCode486
 */
public class LeetCode877 {

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            // 由于是相对分数，有可能是在负值里面选较大者，因此初始化的时候不能为 0
            Arrays.fill(memo[i], Integer.MIN_VALUE);
            memo[i][i] = piles[i];
        }
        return dfs(piles, 0, n - 1, memo) > 0;
    }

    private int dfs(int[] piles, int i, int j, int[][] memo) {
        if (i == j) {
            return piles[i];
        }
        if (memo[i][j] != Integer.MIN_VALUE) {
            return memo[i][j];
        }
        memo[i][j] = Math.max(piles[i] - dfs(piles, i + 1, j, memo), piles[j] - dfs(piles, i, j - 1, memo));
        return memo[i][j];
    }

    public boolean stoneGame_dp(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] > 0;
    }
}
