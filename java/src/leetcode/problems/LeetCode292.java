package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024.01.02 19:33
 */
public class LeetCode292 {

    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    public boolean canWinNim_dfs(int n) {
        Boolean[] memo = new Boolean[n + 1];
        return dfs(n, memo);
    }

    private Boolean dfs(int n, Boolean[] memo) {
        if (n <= 3) {
            return true;
        }
        if (memo[n] != null) {
            return memo[n];
        }
        boolean res = false;
        for (int i = 1; i <= 3; i++) {
            res = res || !dfs(n - i, memo);
        }
        memo[n] = res;
        return res;
    }
}
