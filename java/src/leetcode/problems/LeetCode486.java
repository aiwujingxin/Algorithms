package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2023/12/06 22:29
 */
public class LeetCode486 {

    public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int n = nums.length;
        int[][] momo = new int[n][n];
        return dfs(nums, 0, n - 1, momo) >= 0;
    }

    private int dfs(int[] nums, int i, int j, int[][] momo) {
        if (i > j) {
            return 0;
        }
        // （选择当前数-对手的分数) > 0
        momo[i][j] = Math.max(nums[i] - dfs(nums, i + 1, j, momo),
                nums[j] - dfs(nums, i, j - 1, momo));
        return momo[i][j];
    }

    public boolean PredictTheWinner_dp(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }

        // dp[i][j] 表示作为先手，在区间 nums[i..j] 里进行选择可以获得的 相对分数。
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] >= 0;
    }
}
