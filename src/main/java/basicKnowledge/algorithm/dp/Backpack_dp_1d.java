package basicKnowledge.algorithm.dp;

import basicKnowledge.problems.BackPack;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/13 12:37
 */
public class Backpack_dp_1d implements BackPack {

    @Override
    public int Backpack(int[] value, int[] weight, int W) {
        //滚动数组
        int[] dp = new int[W + 1];
        for (int i = 1; i < value.length + 1; i++) {
            //逆序实现
            for (int j = W; j >= weight[i - 1]; j--) {
                dp[j] = Math.max(dp[j - weight[i - 1]] + value[i - 1], dp[j]);
            }
        }
        return dp[W];
    }
}
