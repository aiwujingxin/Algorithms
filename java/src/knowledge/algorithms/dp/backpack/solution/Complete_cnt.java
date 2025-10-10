package knowledge.algorithms.dp.backpack.solution;

import knowledge.algorithms.dp.backpack.complete.CompletePack;

/**
 * @author wujingxinit@outlook.com
 * @date 10/10/25 15:37
 */
public class Complete_cnt implements CompletePack {

    public int backPack(int[] C, int[] W, int V) {
        int[] dp = new int[V + 1];
        int[] cnt = new int[V + 1];
        cnt[0] = 1;
        for (int i = 0; i < C.length; i++) {
            for (int v = C[i]; v <= V; v++) {
                if (dp[v - C[i]] + W[i] > dp[v]) {
                    dp[v] = dp[v - C[i]] + W[i];
                    cnt[v] = cnt[v - C[i]];
                } else if (dp[v - C[i]] + W[i] == dp[v]) {
                    cnt[v] += cnt[v - C[i]];
                }
            }
        }
        System.out.println("最优选法的方案数:" + cnt[V]);
        return dp[V];
    }
}
