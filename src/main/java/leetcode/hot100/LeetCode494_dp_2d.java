package leetcode.hot100;

import java.util.Arrays;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/9/11 19:35
 */
public class LeetCode494_dp_2d {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (target > sum || target < -1 * sum) {
            return 0;
        }
        int[][] dp = new int[nums.length + 1][sum * 2 + 1];
        dp[0][sum] = 1;
        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 0; j < sum * 2 + 1; j++) {
                if (j - nums[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j + nums[i - 1]];
                } else if (j + nums[i - 1] > sum * 2) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j + nums[i - 1]];
                }
            }
        }
        return dp[nums.length][target + sum];
    }
}
