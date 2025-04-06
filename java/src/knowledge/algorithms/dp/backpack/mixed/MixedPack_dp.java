package knowledge.algorithms.dp.backpack.mixed;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/29 23:14
 * @link <a href="https://www.acwing.com/solution/content/53633/"></a>
 */
public class MixedPack_dp implements MixedPack {

    int V;
    int[] dp;

    @Override
    public int backPack(int[] C, int[] W, int[] S, int[] T, int V) {
        int n = C.length;
        this.V = V;
        this.dp = new int[V + 1];
        for (int i = 0; i < n; i++) {
            if (T[i] == 0) {
                completedPack(C[i], W[i]);
            } else {
                //将 01背包转化成多重背包
                if (T[i] == -1) {
                    S[i] = 1;
                }
                // 二进制优化
                for (int k = 1; k < S[i]; k <<= 1) {
                    zeroOneBackpack(k * C[i], k * W[i]);
                    S[i] -= k;
                }
                if (S[i] > 0) {
                    zeroOneBackpack(S[i] * C[i], S[i] * W[i]);
                }
            }
        }
        return dp[V];
    }

    private void zeroOneBackpack(int v, int w) {
        for (int j = V; j >= v; j--) dp[j] = Math.max(dp[j], dp[j - v] + w);
    }

    private void completedPack(int v, int w) {
        for (int j = v; j <= V; j++) dp[j] = Math.max(dp[j], dp[j - v] + w);
    }

}
