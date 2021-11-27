package LeetCode;

/**
 * @author jingxinwu
 * @date 2021-11-16 11:21 下午
 */
public class LeetCode53 {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //dp[i] 以i为结尾的子数组
        int[] dp = new int[nums.length];
        int res = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + (Math.max(dp[i - 1], 0));
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
