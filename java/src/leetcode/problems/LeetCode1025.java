package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/5 22:41
 */
public class LeetCode1025 {

    public boolean divisorGame(int n) {
        Boolean[] memo = new Boolean[n + 1];
        return dfs(n, memo);
    }

    public boolean dfs(int n, Boolean[] memo) {
        if (n == 1) {
            return false;
        }
        boolean canWin = false;
        if (memo[n] != null) {
            return memo[n];
        }
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0 && !dfs(n - i, memo)) {
                canWin = true;
                break;
            }
        }
        return memo[n] = canWin;
    }
}
