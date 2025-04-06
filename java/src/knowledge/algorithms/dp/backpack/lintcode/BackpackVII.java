package knowledge.algorithms.dp.backpack.lintcode;

import knowledge.algorithms.dp.backpack.multiple.MultiplePack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/7 22:18
 * @description 多重背包
 * @link <a href="https://github.com/cherryljr/LintCode/blob/master/Backpack%20VII.java"></a>
 * 假设你身上有 m 元，超市里有多种大米可以选择，每种大米都是袋装的，必须整袋购买，给出每种大米的重量，价格以及数量，求最多能买多少公斤的大米
 * @see MultiplePack
 */
public class BackpackVII {

    public int backPackVII(int m, int[] prices, int[] weight, int[] amounts) {
        int n = prices.length;
        int[] dp = new int[m + 1];
        for (int i = 0; i <= amounts[0]; i++) {
            if (i * prices[0] <= m) {
                dp[i * prices[0]] = i * weight[0];
            }
        }
        for (int i = 1; i < n; i++) {
            if (prices[i] * amounts[i] > m) {
                completedBackpack(dp, prices[i], weight[i], m);
            } else {
                for (int k = 1; k < amounts[i]; k <<= 1) {  // 二进制的思想
                    zeroOneBackpack(dp, k * prices[i], k * weight[i], m);
                    amounts[i] -= k;
                }
                zeroOneBackpack(dp, amounts[i] * prices[i], amounts[i] * weight[i], m);
            }
        }
        return dp[m];
    }

    private void zeroOneBackpack(int[] dp, int price, int weight, int m) {
        for (int j = m; j >= price; j--) dp[j] = Math.max(dp[j], dp[j - price] + weight);
    }

    private void completedBackpack(int[] dp, int price, int weight, int m) {
        for (int j = price; j <= m; j++) dp[j] = Math.max(dp[j], dp[j - price] + weight);
    }
}
