package basic.algorithm.dp.knapsack.zeroOne;

import basic.algorithm.dp.knapsack.Knapsack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/27 00:17
 */
public class ZeroOnePack_backtrack implements Knapsack {

    int ans;
    int temp;

    @Override
    public int backPack(int packageWeight, int[] weight, int[] goodsValue) {
        backtrack(0, 0, packageWeight, goodsValue, weight);
        return ans;
    }

    public void backtrack(int depth, int sum, int packageWeight, int[] goodsValue, int[] weight) {
        if (sum > packageWeight) {
            return;
        }
        ans = Math.max(ans, temp);
        for (int i = depth; i < goodsValue.length; i++) {
            temp += goodsValue[i];
            sum += weight[i];
            //注意此处是i+1，不是depth+1
            backtrack(i + 1, sum, packageWeight, goodsValue, weight);
            temp -= goodsValue[i];
            sum -= weight[i];
        }
    }
}
