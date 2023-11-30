package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2022-02-18 2:36 PM
 */
public class LeetCode486 {

    public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int[][] momo = new int[nums.length][nums.length];
        return dfs(nums, 0, nums.length - 1, momo) >= 0;
    }

    private int dfs(int[] nums, int i, int j, int[][] momo) {
        if (i > j) {
            return 0;
        }
        momo[i][j] = Math.max(nums[i] - dfs(nums, i + 1, j, momo), nums[j] - dfs(nums, i, j - 1, momo));
        return momo[i][j];
    }

    public boolean PredictTheWinner_dp(int[] nums) {
        int length = nums.length;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = nums[i];
        }

        // dp[i][j] 表示作为先手，在区间 nums[i..j] 里进行选择可以获得的 相对分数。
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][length - 1] >= 0;
    }
}
