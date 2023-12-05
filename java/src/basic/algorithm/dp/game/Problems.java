package basic.algorithm.dp.game;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/5 22:07
 * @see leetcode.problems.LeetCode292
 * @see leetcode.problems.LeetCode464
 * @see leetcode.problems.LeetCode1025
 * @see leetcode.problems.LeetCode486 预测赢家
 * @see leetcode.problems.LeetCode877 石子游戏
 * @see leetcode.problems.LeetCode1140 石子游戏 II
 * @see leetcode.problems.LeetCode1406 石子游戏 III
 * @see leetcode.problems.LeetCode1510 石子游戏 IV
 */
public interface Problems {

    private boolean canIWin(int n) {
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
                res = res || !dfs(n - i, memo);
            }
        }
        return memo[n] = res;
    }
}
