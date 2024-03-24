package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/21 23:04
 * @description 完全背包 方案排列数
 */
public class LeetCode377 {

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
