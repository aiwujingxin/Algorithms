package leetcode.problems;

import java.util.Arrays;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/21 23:51
 */
public class LeetCode410 {

    public int splitArray(int[] nums, int m) {
        int n = nums.length;

        //我们可以令f[i][j] 表示将数组的前 i 个数分割为 j 段所能得到的最大连续子数组和的最小值
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        int[] presum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            presum[i] = presum[i - 1] + nums[i - 1];
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, m); j++) {
                for (int k = 0; k < i; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], presum[i] - presum[k]));
                }
            }
        }
        return dp[n][m];
    }
}
