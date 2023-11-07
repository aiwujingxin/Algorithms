package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/25 00:07
 * @description 完全背包 方案数
 */
public class LeetCode377 {

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}