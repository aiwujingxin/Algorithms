package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/17 20:42
 */
public class LeetCode300 {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            int t = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    t = Math.max(dp[j], t);
                }
            }
            dp[i] = t + 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
