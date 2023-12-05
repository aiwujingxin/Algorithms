package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/6 01:20
 * @link <a href="https://leetcode.cn/problems/nim-game/solutions/370009/ji-yi-hua-di-gui-dong-tai-gui-hua-guan-cha-gui-lu-/">...</a>
 */
public class LeetCode292 {

    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    public boolean canWinNim_dfs(int n) {
        Boolean[] memo = new Boolean[n + 1];
        return dfs(n, memo);
    }

    private boolean dfs(int n, Boolean[] memo) {
        if (n < 0) {
            return false;
        }
        if (memo[n] != null) {
            return memo[n];
        }
        boolean res = false;
        for (int i = 1; i < 4; i++) {
            if (n >= i) {
                res |= !dfs(n - i, memo);
            }
        }
        return memo[n] = res;
    }

    public boolean canWinNim_dp(int n) {
        if (n <= 3) {
            return true;
        }
        boolean[] dp = new boolean[n + 1];
        dp[1] = true;
        dp[2] = true;
        dp[3] = true;
        for (int i = 4; i <= n; i++) {
            // 如果 3 种选择，只要有一种对方输掉，自己就可以赢
            dp[i] = !dp[i - 1] || !dp[i - 2] || !dp[i - 3];
        }
        return dp[n];
    }
}
