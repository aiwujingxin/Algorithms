package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/20 20:13
 */
public class LeetCode375 {

    static int[][] memo;

    public int getMoneyAmount(int n) {
        memo = new int[n + 1][n + 1];
        return dfs(1, n);
    }

    int dfs(int l, int r) {
        if (l >= r) {
            return 0;
        }
        if (memo[l][r] != 0) {
            return memo[l][r];
        }
        int ans = Integer.MAX_VALUE;
        for (int k = l; k <= r; k++) {
            int cur = Math.max(dfs(l, k - 1), dfs(k + 1, r)) + k;
            ans = Math.min(ans, cur);
        }
        memo[l][r] = ans;
        return ans;
    }
}
