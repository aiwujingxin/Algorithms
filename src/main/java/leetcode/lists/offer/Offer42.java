package leetcode.lists.offer;

/**
 * @author jingxinwu
 * @date 2021-11-22 10:45 下午
 */
public class Offer42 {


    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = Integer.MIN_VALUE;

        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i] + Math.max(nums[i - 1], 0);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
