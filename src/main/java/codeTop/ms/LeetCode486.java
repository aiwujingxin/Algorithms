package codeTop.ms;

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

}
