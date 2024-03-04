package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/4 19:59
 */
public class LeetCode918 {

    public int maxSubarraySumCircular(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        int res = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], 0) + nums[i];
            res = Math.max(res, dp[i]);
        }
        int[] presum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            presum[i] = presum[i - 1] + nums[i - 1];
        }
        int max = Integer.MIN_VALUE;
        int[] g = new int[n];
        for (int i = 1; i <= n; i++) {
            max = Math.max(presum[i] - presum[0], max);
            g[i] = max;
        }
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, presum[n] - presum[i] + g[i - 1]);
        }
        return res;
    }
}

