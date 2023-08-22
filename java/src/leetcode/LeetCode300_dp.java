package leetcode;

/**
 * @author jingxinwu
 * @date 2021-08-18 2:02 上午
 * @see LeetCode673
 * @see LeetCode354_dp_binary 俄罗斯套娃信封问题
 */
public class LeetCode300_dp {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            //fix
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
