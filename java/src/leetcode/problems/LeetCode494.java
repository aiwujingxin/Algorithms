package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/6 13:50
 */
public class LeetCode494 {

    public int findTargetSumWays(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if ((sum + target) % 2 != 0) {
            return 0;
        }
        int total = (sum + target) / 2;
        if (total < 0) {
            return 0;
        }
        int[] dp = new int[total + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = total; i >= 0; i--) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[total];
    }
}
