package leetcode.problems;

/**
 * @author aiwujingxin@gmail.com
 * @date 2023/9/20 14:49
 */
public class LeetCode494_dp_1d {

    //https://leetcode.com/problems/target-sum/discuss/2479879/Java-or-subset-or-dp

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
        if (Math.abs(target) > Math.abs(sum)) {
            return 0;
        }
        int total = (sum + target) / 2;
        int[] dp = new int[total + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = total; i >= 0; i--) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[total];
    }
}
