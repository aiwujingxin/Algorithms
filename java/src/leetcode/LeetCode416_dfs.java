package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/28 21:03
 */
public class LeetCode416_dfs {

    // <OfferII> P295
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int max = 0;
        for (int i : nums) {
            sum += i;
            max = Math.max(max, i);
        }
        if (sum % 2 != 0 || max > sum / 2) {
            return false;
        }
        return canPartition(nums, sum / 2);
    }

    private boolean canPartition(int[] nums, int target) {
        Boolean[][] dp = new Boolean[nums.length + 1][target + 1];
        return helper(nums, dp, nums.length, target);
    }

    private boolean helper(int[] nums, Boolean[][] dp, int i, int j) {
        if (dp[i][j] == null) {
            if (j == 0) {
                dp[i][j] = true;
            } else if (i == 0) {
                dp[i][j] = false;
            } else {
                dp[i][j] = helper(nums, dp, i - 1, j);
                if (!dp[i][j] && j > nums[i - 1]) {
                    dp[i][j] = helper(nums, dp, i - 1, j - nums[i - 1]);
                }
            }
        }
        return dp[i][j];
    }
}
