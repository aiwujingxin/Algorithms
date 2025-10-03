package knowledge.algorithms.dp.backpack.lintcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/8 18:30
 * @description 完全背包
 * @link <a href="https://github.com/cherryljr/LintCode/blob/master/Backpack%20X.java">...</a>
 * 你总共有n元，商人总共有三种商品，它们的价格分别是150元,250元,350元，三种商品的数量可以认为是无限多的，
 * 购买完商品以后需要将剩下的钱给商人作为小费，求最少需要给商人多少小费
 */
public class BackPackX {

    public int backPack(int n) {
        int[] coins = new int[]{150, 250, 350};
        int[] dp = new int[n + 1];
        for (int i = 0; i * coins[0] <= n; i++) {
            dp[i * coins[0]] = i * coins[0];
        }
        for (int coin : coins) {
            for (int j = coin; j <= n; j++) {
                dp[j] = Math.max(dp[j], dp[j - coin] + coin);
            }
        }
        return n - dp[n];
    }
}
