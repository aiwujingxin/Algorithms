package knowledge.dp.backpack.zeroOne;


/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/13 12:37
 */
public class ZeroOne_dp_1d implements ZeroOnePack {

    @Override
    public int backPack(int[] C, int[] W, int V) {
        int N = C.length;
        int[] dp = new int[V + 1];
        for (int i = 0; i < N; i++) {
            for (int v = V; v >= C[i]; v--) {
                dp[v] = Math.max(dp[v], dp[v - C[i]] + W[i]);
            }
        }
        return dp[V];
    }
}
