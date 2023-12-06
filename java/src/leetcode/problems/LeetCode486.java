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
}
