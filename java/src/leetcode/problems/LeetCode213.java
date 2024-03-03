package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/3 13:47
 */
public class LeetCode213 {

    int[] dp;

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        this.dp = new int[n];
        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
    }

    public int rob(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
        }
        if (l + 1 == r) {
            return Math.max(nums[l], nums[r]);
        }
        dp[l] = nums[l];
        dp[l + 1] = Math.max(nums[l], nums[l + 1]);
        for (int i = l + 2; i <= r; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[r];
    }
}
