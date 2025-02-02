package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2/2/25 18:20
 */
public class LeetCode2770 {

    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                if (-target <= nums[j] - nums[i] && nums[j] - nums[i] <= target) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        if (dp[n - 1] < 0) {
            return -1;
        }
        return dp[n - 1];
    }
}
