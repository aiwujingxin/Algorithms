package leetcode.topinterview;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/22 01:34
 */
public class LeetCode53 {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + Math.max(dp[i - 1], 0);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
