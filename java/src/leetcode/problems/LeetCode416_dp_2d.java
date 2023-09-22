package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/25 22:48
 */
public class LeetCode416_dp_2d {
    //https://leetcode.com/problems/partition-equal-subset-sum/solutions/1624101/java-memoization-to-optimized-dp-detailed-explanation/

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n][target + 1];

        dp[0][0] = true;
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                //考虑当前数
                if (nums[i] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                } else {
                    //不考虑当前值
                    dp[i][j] = dp[i - 1][j];
                }
            }
            if (dp[i][target]) {
                return true;
            }
        }
        return dp[n - 1][target];
    }
}
