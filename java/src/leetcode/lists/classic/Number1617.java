package leetcode.lists.classic;

/**
 * @author jingxinwu
 * @date 2021-12-05 3:47 下午
 */
public class Number1617 {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int res = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + Math.max(dp[i - 1], 0);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
