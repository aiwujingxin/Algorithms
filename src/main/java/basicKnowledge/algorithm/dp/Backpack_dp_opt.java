package basicKnowledge.algorithm.dp;

import basicKnowledge.problems.BackPack;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/13 12:37
 */
public class Backpack_dp_opt implements BackPack {



    @Override
    public int Backpack(int[] goodsValue, int[] goodsWeight, int packageWeight) {
        //动态规划
        int[] dp = new int[packageWeight + 1];
        for (int i = 1; i < goodsValue.length + 1; i++) {
            //逆序实现
            for (int j = packageWeight; j >= goodsWeight[i - 1]; j--) {
                dp[j] = Math.max(dp[j - goodsWeight[i - 1]] + goodsValue[i - 1], dp[j]);
            }
        }
        return dp[packageWeight];
    }
}
