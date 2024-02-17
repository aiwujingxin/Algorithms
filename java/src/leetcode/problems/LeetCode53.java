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
        int max = nums[0];
        dp[0] = max;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(0, dp[i - 1]) + nums[i];
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
