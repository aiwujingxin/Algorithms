package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/28 18:54
 */
public class LeetCode416 {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = target; i >= 0; i--) {
                if (i >= num) {
                    dp[i] |= dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
