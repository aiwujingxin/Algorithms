package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/10 17:37
 * @description dp[i][j]: 从第 i 堆到第 j 堆，当前玩家（先手）相对于另一个玩家（后手）所能获得的最大 净得分差（先手得分 - 后手得分）。
 */
public class LeetCode877 {

    Integer[][] memo;
    int[] piles;

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        this.memo = new Integer[n][n];
        this.piles = piles;
        return dfs(0, n - 1) > 0;
    }

    private int dfs(int i, int j) {
        if (i == j) {
            return piles[i];
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        memo[i][j] = Math.max(piles[i] - dfs(i + 1, j), piles[j] - dfs(i, j - 1));
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
