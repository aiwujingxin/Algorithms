package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/18 21:51
 */
public class LeetCode198_dp_2d {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = dp[i - 1][1] + nums[i];
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }
}
