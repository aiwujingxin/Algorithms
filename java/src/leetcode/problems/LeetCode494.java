package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/6 13:50
 */
public class LeetCode494 {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if ((target + sum) % 2 == 1 || target + sum < 0) {
            return 0;
        }
        int amount = (target + sum) / 2;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = amount; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[amount];
    }
}
