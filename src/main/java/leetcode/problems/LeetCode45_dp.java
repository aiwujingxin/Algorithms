package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/8 21:58
 */
public class LeetCode45_dp {

    //https://leetcode.com/problems/jump-game-ii/discuss/1192401/Easy-Solutions-w-Explanation-or-Optimizations-from-Brute-Force-to-DP-to-Greedy-BFS
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 10001);
        dp[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            for (int jumpLen = 1; jumpLen <= nums[i]; jumpLen++) {
                dp[i] = Math.min(dp[i], 1 + dp[Math.min(n - 1, i + jumpLen)]);  // min(n-1, i + jumpLen) for bounds handling
            }
        }
        return dp[0];
    }
}
