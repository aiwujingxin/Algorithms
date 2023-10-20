package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/20 16:06
 */
public class LeetCode53 {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = Math.max(nums[0], 0);
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], 0) + nums[i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
