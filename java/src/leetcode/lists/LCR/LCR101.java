package leetcode.lists.LCR;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/26 11:51
 */
public class LCR101 {

    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int n : nums) {
            for (int i = target; i >= 0; i--) {
                if (n <= i) {
                    dp[i] = dp[i] | dp[i - n];
                }
            }
        }
        return dp[target];
    }
}
