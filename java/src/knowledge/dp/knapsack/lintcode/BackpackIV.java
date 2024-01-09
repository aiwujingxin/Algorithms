package knowledge.dp.knapsack.lintcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/7 22:17
 * @description 完全背包 唯一排列 方案数
 * <a href="https://www.lintcode.com/problem/562/">backPackIV</a>
 */

/*
 *给出 n 个物品, 以及一个数组, nums[i]代表第i个物品的大小, 保证大小均为正数并且没有重复, 正整数 target 表示背包的大小, 找到能填满背包的方案数。
 *每一个物品可以使用无数次
 * */
public class BackpackIV {

    public int backPackIV_2d(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                for (int k = 1; k * nums[i - 1] <= j; k++) {
                    dp[i][j] += dp[i - 1][j - k * nums[i - 1]];
                }
            }
        }
        return dp[n][target];
    }

    public int backPackIV_1d(int[] nums, int target) {
        int[] dp = new int[target + 1];
        for (int i = 0; i * nums[0] <= target; i++) {
            dp[i * nums[0]] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = nums[i]; j <= target; j++) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
