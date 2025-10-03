package knowledge.algorithms.dp.backpack.lintcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/7 22:17
 * @description 完全背包 组合数
 * @link <a href="https://www.lintcode.com/problem/562/">backPackIV</a>
 * 给出 n 个物品, 以及一个数组, nums[i]代表第i个物品的大小, 保证大小均为正数并且没有重复, 正整数 target 表示背包的大小, 找到能填满背包的方案数。
 * 每一个物品可以使用无数次
 * @see leetcode.problems.LeetCode518
 */
public class BackpackIV {

    public int backPackIV(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = num; j <= target; j++) {
                dp[j] += dp[j - num];
            }
        }
        return dp[target];
    }
}
