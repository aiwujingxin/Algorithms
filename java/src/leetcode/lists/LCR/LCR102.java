package leetcode.lists.LCR;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/26 14:08
 */
public class LCR102 {

    public int findTargetSumWays(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
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
