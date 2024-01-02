package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/5 23:17
 */
public class LeetCode1510 {

    public boolean winnerSquareGame(int n) {
        Boolean[] memo = new Boolean[n + 1];
        return dfs(n, memo);
    }

    private boolean dfs(int n, Boolean[] memo) {
        if (memo[n] != null) {
            return memo[n];
        }
        for (int i = 1; i < (int) Math.sqrt(n); i++) {
            if (!dfs(n - (i * i), memo)) {
                return memo[n] = true;
            }
        }
        return memo[n] = false;
    }
}
