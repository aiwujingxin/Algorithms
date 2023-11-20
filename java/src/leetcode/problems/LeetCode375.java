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
        for (int x = l; x <= r; x++) {
            // 当选择的数位 x 时，至少需要 cur 才能猜中数字
            int cur = Math.max(dfs(l, x - 1), dfs(x + 1, r)) + x;
            // 在所有我们可以决策的数值之间取最优
            ans = Math.min(ans, cur);
        }
        memo[l][r] = ans;
        return ans;
    }
}
