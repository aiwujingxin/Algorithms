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
}
