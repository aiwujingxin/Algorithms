package codeTop.ms;

/**
 * @author jingxinwu
 * @date 2022-02-17 8:46 PM
 */
public class LeetCode300 {

    public int lengthOfLIS(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        //fix res
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            int temp = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    temp = Math.max(temp, dp[j]);
                }
            }
            dp[i] = temp + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
