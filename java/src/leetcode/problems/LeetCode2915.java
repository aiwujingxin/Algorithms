package leetcode.problems;

import java.util.Arrays;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 8/14/25 01:16
 * @description 注意初始化条件
 */
public class LeetCode2915 {

    public int lengthOfLongestSubsequence_1d(List<Integer> nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for (int num : nums) {
            for (int c = target; c >= num; c--) {
                dp[c] = Math.max(dp[c], dp[c - num] + 1);
            }
        }
        return dp[target] < 0 ? -1 : dp[target];
    }

    public int lengthOfLongestSubsequence_2d(List<Integer> nums, int target) {
        int n = nums.size();
        int[][] dp = new int[n + 1][target + 1];
        Arrays.fill(dp[0], Integer.MIN_VALUE);
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int v = 1; v <= target; v++) {
                dp[i][v] = dp[i - 1][v];
                if (v >= nums.get(i - 1)) {
                    dp[i][v] = Math.max(dp[i - 1][v], dp[i - 1][v - nums.get(i - 1)] + 1);
                }
            }
        }
        return dp[n][target] < 0 ? -1 : dp[n][target];
    }
}
