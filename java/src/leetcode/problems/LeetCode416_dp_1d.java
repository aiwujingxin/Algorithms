package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2021-12-13 1:07 AM
 */
public class LeetCode416_dp_1d {

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int j = target; j >= 0; --j) {
                if (num <= j) {
                    dp[j] |= dp[j - num];
                }
            }
        }
        return dp[target];
    }
}
