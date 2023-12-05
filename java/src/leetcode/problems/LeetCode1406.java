package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/5 23:09
 */
public class LeetCode1406 {

    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] memo = new int[n];
        Arrays.fill(memo, Integer.MIN_VALUE);
        int s = dfs(stoneValue, 0, memo);
        if (s == 0) {
            return "Tie";
        }
        if (s > 0) {
            return "Alice";
        }
        return "Bob";
    }

    private int dfs(int[] stoneValue, int cur, int[] memo) {
        if (cur == stoneValue.length) {
            return 0;
        }
        if (memo[cur] != Integer.MIN_VALUE) {
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
