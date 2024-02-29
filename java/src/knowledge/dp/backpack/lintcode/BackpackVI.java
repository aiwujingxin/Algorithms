package knowledge.dp.backpack.lintcode;

import leetcode.problems.LeetCode377;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/7 22:18
 * @description 完全背包 排列数
 * 给定一个包含所有正数且没有重复数的整数nums，找出加起来等于正整数target的可能组合的数目。
 * @see LeetCode377
 */
public class BackpackVI {

    public int backPackVI(int[] nums, int target) {
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
