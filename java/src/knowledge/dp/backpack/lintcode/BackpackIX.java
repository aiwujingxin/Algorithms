package knowledge.dp.backpack.lintcode;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/8 18:28
 * @description 01背包
 * 你总共有10 * n 千元(n万元 )，希望申请国外的大学，要申请的话需要交一定的申请费用，给出每个大学的申请费用以及你得到这个大学offer的成功概率，大学的数量是 m。
 * 如果经济条件允许，你可以申请多所大学。找到获得至少一份工作的最高可能性。
 * <a href="https://github.com/cherryljr/NowCoder/blob/master/%E6%95%B0%E7%BB%84%E5%92%8C%E4%B8%BAsum%E7%9A%84%E6%96%B9%E6%B3%95%E6%95%B0.java">...</a>
 */
public class BackpackIX {

    public double backpackIX(int n, int[] prices, double[] probability) {
        if (probability == null || probability.length == 0) {
            return 0.0;
        }
        double[] dp = new double[n + 1];
        Arrays.fill(dp, 1.0);
        for (int i = 0; i < probability.length; i++) {
            probability[i] = 1 - probability[i];
        }

        for (int i = 0; i < probability.length; i++) {
            for (int j = n; j >= prices[i]; j--) {
                dp[j] = Math.min(dp[j], dp[j - prices[i]] * probability[i]);
            }
        }
        return 1 - dp[n];
    }
}
