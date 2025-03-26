package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/7 13:09
 */
public class LeetCode486 {

    Integer[][] memo;

    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        memo = new Integer[n][n];
        return dfs(nums, 0, n - 1) >= 0;
    }

    private int dfs(int[] nums, int l, int r) {
        if (l > r) {
            return 0;
        }
        if (memo[l][r] != null) {
            return memo[l][r];
        }
        memo[l][r] = Math.max(nums[l] - dfs(nums, l + 1, r), nums[r] - dfs(nums, l, r - 1));
        return memo[l][r];
    }
}
