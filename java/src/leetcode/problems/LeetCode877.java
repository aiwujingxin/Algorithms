package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/10 17:37
 */
public class LeetCode877 {

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        Integer[][] memo = new Integer[n][n];
        return dfs(piles, 0, n - 1, memo) > 0;
    }

    private int dfs(int[] piles, int i, int j, Integer[][] memo) {
        if (i == j) {
            return piles[i];
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        memo[i][j] = Math.max(piles[i] - dfs(piles, i + 1, j, memo), piles[j] - dfs(piles, i, j - 1, memo));
        return memo[i][j];
    }
}
