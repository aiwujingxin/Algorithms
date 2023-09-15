package leetcode.offer;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/13 00:53
 */
public class Offer42 {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(0, nums[i]) + dp[i - 1];
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
