package leetcode;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/14 02:18
 */
public class LeetCode300_dfs_memo {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return helper(nums, 0, -1, dp);
    }

    public int helper(int[] nums, int ind, int prev, int[][] dp) {
        if (ind == nums.length) {
            return 0;
        }

        if (prev != -1 && dp[ind][prev] != -1) {
            return dp[ind][prev];
        }

        int op1 = helper(nums, ind + 1, prev, dp);
        int op2 = 0;
        if (prev == -1 || nums[prev] < nums[ind]) {
            op2 = 1 + helper(nums, ind + 1, ind, dp);
        }
        if (prev != -1) {
            dp[ind][prev] = Math.max(op1, op2);
        }

        return Math.max(op1, op2);
    }
}
