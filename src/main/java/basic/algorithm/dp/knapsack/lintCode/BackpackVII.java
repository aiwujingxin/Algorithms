package basic.algorithm.dp.knapsack.lintCode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/7 22:18
 * @description 多重背包
 * {@link basic.algorithm.dp.knapsack.multiple.MultiplePack_1d}
 * <a href="https://github.com/cherryljr/LintCode/blob/master/Backpack%20VII.java"></a>
 */
/*
 * 假设你身上有 n 元，超市里有多种大米可以选择，每种大米都是袋装的，必须整袋购买，给出每种大米的重量，价格以及数量，求最多能买多少公斤的大米
 * */
public class BackpackVII {
    /**
     * Approach 3: Multiple Backpack (Optimized by Binary Code)
     * 在 Approach 2 的基础上，我们可以进一步采用 二进制 的思想对时间复杂度进行优化。
     * 我们考虑把第 i 种物品换成若干件物品，使得原问题中第 i 种物品可取的每种策略：
     * 取 0~amounts[i] 件 —— 均能等价于取若干件代换以后的物品。
     * (另外，取超过 amounts[i] 件的策略必不能出现。)
     * 方法是：将第 i 种物品分成若干件 01 背包中的物品，其中每件物品有一个系数。
     * 这件物品的费用和价值均是原来的费用和价值乘以这个系数。
     * 令这些系数分别为 1; 2; 2^2 …… 2^(k−1); amounts[i] − 2^k + 1，且 k 是满足 amounts[i] − 2k + 1 > 0 的最大整数。
     * 例如，如果 amounts[i] 为 13，则相应的 k = 3，这种最多取 13 件的物品应被分成系数分别为 1; 2; 4; 6 的四件物品
     * <p>
     * 时间复杂度为：O(N*M*logK)； 空间复杂度为：O(M)
     * <p>
     * 该解法需要对 01背包 和 完全背包 都有着较为深刻的认识，若不清楚的可以参考：
     * 数组和为sum的方法数（01背包问题分析）：
     * <a href="https://github.com/cherryljr/NowCoder/blob/master/%E6%95%B0%E7%BB%84%E5%92%8C%E4%B8%BAsum%E7%9A%84%E6%96%B9%E6%B3%95%E6%95%B0.java">...</a>
     * 换零钱（完全背包问题分析）：
     * <a href="https://github.com/cherryljr/NowCoder/blob/master/%E6%8D%A2%E9%9B%B6%E9%92%B1.java">...</a>
     */

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
