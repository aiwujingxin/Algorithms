package leetcode.problems;

import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/27 23:19
 */
public class LeetCode629_dp_1d {


    //https://leetcode.cn/problems/k-inverse-pairs-array/solution/python-ji-yi-hua-di-gui-by-himymben-bujz/
    private static final int MOD = 1000000007;

    public int kInversePairs(int n, int k) {
        // dp[n][k] - dp[n][k-1] = dp[n-1][k] - dp[n-1][k-n] if k >= n else dp[n-1][k]
        int[] dp = new int[k + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for (int i = 2; i <= n; i++) {
            int[] next_dp = new int[k + 1];
            Arrays.fill(next_dp, 0);
            next_dp[0] = 1;
            for (int j = 1; j <= k; j++) {
                next_dp[j] = (next_dp[j - 1] + dp[j]) % MOD;
                if (j >= i) {
                    next_dp[j] = (next_dp[j] - dp[j - i] + MOD) % MOD;
                }
            }
            dp = next_dp;
        }
        return dp[k];
    }
}
