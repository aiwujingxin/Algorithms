package basic.algorithm.dp.knapsack.zeroOne;

import basic.algorithm.dp.knapsack.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/13 12:37
 * <a href="https://www.lintcode.com/problem/125/">Backpack II 125</a>
 */
public class ZeroOnePack_dp_1d implements knapsack {

    @Override
    public int backPack(int capacity, int[] weights, int[] values) {
        int[] dp = new int[capacity + 1];
        for (int i = 1; i <= capacity; i++) {
            //滚动数组 逆序实现
            for (int j = capacity; j >= weights[i - 1]; j--) {
                dp[j] = Math.max(dp[j - weights[i - 1]] + values[i - 1], dp[j]);
            }
        }
        return dp[capacity];
    }
}
