package leetcode.lists.hot100;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/14 02:19
 */
public class LeetCode300_dp_2d {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int prev = ind - 1; prev >= -1; prev--) {
                int op1 = dp[ind + 1][prev + 1];
                int op2 = 0;
                if (prev == -1 || nums[prev] < nums[ind]) {
                    op2 = 1 + dp[ind + 1][ind + 1];
                }
                dp[ind][prev + 1] = Math.max(op1, op2);
            }
        }
        return dp[0][0];
    }
}
