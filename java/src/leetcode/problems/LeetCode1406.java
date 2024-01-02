package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/5 23:09
 */
public class LeetCode1406 {

    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        Integer[] memo = new Integer[n];
        int s = dfs(stoneValue, 0, memo);
        if (s == 0) {
            return "Tie";
        }
        if (s > 0) {
            return "Alice";
        }
        return "Bob";
    }

    private int dfs(int[] stoneValue, int cur, Integer[] memo) {
        if (cur == stoneValue.length) {
            return 0;
        }
        if (memo[cur] != null) {
            return memo[cur];
        }
        int res = Integer.MIN_VALUE;
        int score = 0;
        for (int i = cur; i < cur + 3 && i < stoneValue.length; i++) {
            score += stoneValue[i];
            res = Math.max(res, score - dfs(stoneValue, i + 1, memo));
        }
        return memo[cur] = res;
    }
}
