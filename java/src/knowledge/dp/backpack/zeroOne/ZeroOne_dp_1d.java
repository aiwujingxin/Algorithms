package knowledge.dp.backpack.zeroOne;


import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/13 12:37
 */
public class ZeroOne_dp_1d implements ZeroOnePack {

    @Override
    public int backPack(int[] C, int[] W, int V) {
        int N = C.length;
        int[] dp = new int[V + 1];
        int[] cnt = new int[V + 1];
        Arrays.fill(cnt, 1);
        for (int i = 0; i < N; i++) {
            for (int v = V; v >= C[i]; v--) {
                if (dp[v] == dp[v - C[i]] + W[i]) {
                    cnt[v] += cnt[v - C[i]];
                } else if (dp[v] < dp[v - C[i]] + W[i]) {
                    cnt[v] = cnt[v - C[i]];
                }
                dp[v] = Math.max(dp[v], dp[v - C[i]] + W[i]);
            }
        }
        System.out.println("最优选法的方案数:" + cnt[V]);
        return dp[V];
    }
}
