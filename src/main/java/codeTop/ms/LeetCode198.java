package codeTop.ms;

/**
 * @author jingxinwu
 * @date 2022-02-16 3:51 PM
 */
public class LeetCode198 {

    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        //fix
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {

            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);

        }

        return dp[dp.length - 1];
    }


}
