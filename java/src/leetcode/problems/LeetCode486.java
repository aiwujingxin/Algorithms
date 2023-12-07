package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/7 13:09
 */
public class LeetCode486 {
    Integer[][] memo;

    public boolean predictTheWinner(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int n = nums.length;
        memo = new Integer[n][n];
        return dfs(nums, 0, n - 1) >= 0;
    }

    private int dfs(int[] nums, int i, int j) {
        if (i > j) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        memo[i][j] = Math.max(nums[i] - dfs(nums, i + 1, j), nums[j] - dfs(nums, i, j - 1));
        return memo[i][j];
    }
}
