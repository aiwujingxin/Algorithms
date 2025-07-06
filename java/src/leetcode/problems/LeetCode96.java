package leetcode.problems;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/4 16:32
 * @description 卡特兰数 区间DP
 */
public class LeetCode96 {

    HashMap<Integer, Integer> memo = new HashMap<>();

    public int numTrees(int n) {
        if (n == 1) {
            return 1;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int left = numTrees(i);
            int right = numTrees(n - i - 1);
            res += left * right;
        }
        memo.put(n, res);
        return res;
    }

    public int numTrees_dp(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
