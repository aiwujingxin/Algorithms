package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/8 22:00
 */
public class LeetCode45_dfs {

    //https://leetcode.com/problems/jump-game-ii/discuss/1192401/Easy-Solutions-w-Explanation-or-Optimizations-from-Brute-Force-to-DP-to-Greedy-BFS

    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 10001);
        return helper(nums, dp, 0);
    }

    private int helper(int[] nums, int[] dp, int index) {
        if (index >= nums.length - 1) {
            return 0;
        }
        if (dp[index] != 10001) {
            return dp[index];
        }
        for (int j = 1; j <= nums[index]; j++) {
            dp[index] = Math.min(dp[index], 1 + helper(nums, dp, index + j));
        }
        return dp[index];
    }
}