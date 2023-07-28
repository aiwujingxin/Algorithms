package basic.algorithm.dp.backpack.zeroOnePack;

import basic.problems.dp.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/13 12:37
 */
public class ZeroOnePack_dp_1d implements BackPack {

    @Override
    public int backPack(int capacity, int[] weight, int[] value) {
        //滚动数组
        int[] dp = new int[capacity + 1];
        for (int i = 1; i < value.length + 1; i++) {
            //逆序实现
            for (int j = capacity; j >= weight[i - 1]; j--) {
                dp[j] = Math.max(dp[j - weight[i - 1]] + value[i - 1], dp[j]);
            }
        }
        return dp[capacity];
    }
}
