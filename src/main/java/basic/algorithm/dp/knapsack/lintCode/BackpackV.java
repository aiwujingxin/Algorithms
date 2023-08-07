package basic.algorithm.dp.knapsack.lintCode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/7 22:17
 * 单次选择+装满可能性总数
 * <a href="https://www.lintcode.com/problem/563/">backPackV</a>
 */

/*
 * 给出 n 个物品, 以及一个数组, nums[i] 代表第i个物品的大小, 保证大小均为正数, 正整数 target 表示背包的大小, 找到能填满背包的方案数。
 *每一个物品只能使用一次
 * */
public class BackpackV {

    public int backPackV(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = target; j >= nums[i - 1]; j--) {
                dp[j] += dp[j - nums[i - 1]];
            }
        }

        return dp[target];
    }
}
