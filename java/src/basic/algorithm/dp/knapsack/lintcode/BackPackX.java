package basic.algorithm.dp.knapsack.lintcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/8 18:30
 * @description 完全背包
 */

/*
 * 你总共有n元，商人总共有三种商品，它们的价格分别是150元,250元,350元，三种商品的数量可以认为是无限多的，
 * 购买完商品以后需要将剩下的钱给商人作为小费，求最少需要给商人多少小费
 *
 * Approach: Completed Backpack
 * dp[i]表示：当金额为 j 时，最多可以花掉多少钱。
 * 因此结果为：n - dp[n]
 * <p>
 * 完全背包问题分析：
 * 换钱的最少货币数：
 * <a href="https://github.com/cherryljr/NowCoder/blob/master/%E6%8D%A2%E9%92%B1%E7%9A%84%E6%9C%80%E5%B0%91%E8%B4%A7%E5%B8%81%E6%95%B0.java">...</a>
 * 换零钱：
 * <a href="https://github.com/cherryljr/NowCoder/blob/master/%E6%8D%A2%E9%9B%B6%E9%92%B1.java"></a>
 */
public class BackPackX {

    public int backPackX(int n) {
        final int[] PRICES = new int[]{150, 250, 350};
        int[] dp = new int[n + 1];
        // Initialize
        for (int i = 0; i * PRICES[0] <= n; i++) {
            dp[i * PRICES[0]] = i * PRICES[0];
        }

        // Function
        for (int i = 1; i < 3; i++) {
            // Gurantee the enough is enough to pay PRICES[i]
            for (int j = PRICES[i]; j <= n; j++) {
                dp[j] = Math.max(dp[j], dp[j - PRICES[i]] + PRICES[i]);
            }
        }
        // Answer
        return n - dp[n];
    }
}
