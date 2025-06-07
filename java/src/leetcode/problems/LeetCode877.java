package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/10 17:37
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

    public boolean stoneGame_dp_len(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] > 0;
    }

    public boolean stoneGame_dp2(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        // base case: when i == j
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }
        // 遍历顺序：i 从 n-2 到 0，j 从 i+1 到 n-1
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] > 0;
    }
}
