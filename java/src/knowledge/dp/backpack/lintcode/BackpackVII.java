package knowledge.dp.backpack.lintcode;

import knowledge.dp.backpack.multiple.MultiplePack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/7 22:18
 * @description 多重背包
 * @link <a href="https://github.com/cherryljr/LintCode/blob/master/Backpack%20VII.java"></a>
 * 假设你身上有 n 元，超市里有多种大米可以选择，每种大米都是袋装的，必须整袋购买，给出每种大米的重量，价格以及数量，求最多能买多少公斤的大米
 * @see MultiplePack
 */
public class BackpackVII {

    public int backPackVII(int m, int[] prices, int[] weight, int[] amounts) {
        int n = prices.length;
        int[] dp = new int[m + 1];
        // Initialize
        for (int i = 0; i <= amounts[0]; i++) {
            if (i * prices[0] <= m) {
                dp[i * prices[0]] = i * weight[0];
            }
        }
        // Function
        // 遍历每种物品
        for (int i = 1; i < n; i++) {
            if (prices[i] * amounts[i] > m) {
                /*
                如果全装进去已经超了总金额，相当于这个物品就是无限的
                因为是取不光的，那么就用完全背包去套
                 */
                completedBackpack(dp, prices[i], weight[i], m);
            } else {
                /*
                取得光的话，去遍历每种取法
                这里用到是二进制思想，降低了复杂度
                为什么呢，因为他取的1,2,4,8...与余数个该物品，打包成一个大型的该物品
                这样足够凑出了从0-k个该物品取法
                把复杂度从k变成了logk
                如k=11，则有1,2,4,4，足够凑出0-11个该物品的取法
                 */
                int k = 1;
                while (k < amounts[i]) {
                    zeroOneBackpack(dp, k * prices[i], k * weight[i], m);
                    amounts[i] -= k;
                    k <<= 1;    // 二进制的思想
                }
                // 最后对余数部分进行一次 01背包 处理
                zeroOneBackpack(dp, amounts[i] * prices[i], amounts[i] * weight[i], m);
            }
        }
        // Answer
        return dp[m];
    }

    // 完全背包问题代码
    private void completedBackpack(int[] dp, int price, int weight, int m) {
        for (int j = price; j <= m; j++) {
            dp[j] = Math.max(dp[j], dp[j - price] + weight);
        }
    }

    // 01背包问题代码
    private void zeroOneBackpack(int[] dp, int price, int weight, int m) {
        for (int j = m; j >= price; j--) {
            dp[j] = Math.max(dp[j], dp[j - price] + weight);
        }
    }
}
