package knowledge.algorithms.dp.backpack.multiple;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/26 22:58
 * @description 多重背包 二进制优化
 */
public class Multiple_bit implements MultiplePack {

    int[] dp;
    int V;

    public int backPack(int[] C, int[] W, int[] K, int V) {
        int N = C.length;
        this.dp = new int[V + 1];
        this.V = V;
        for (int i = 0; i < N; i++) {
            if (C[i] * K[i] > V) {
                completedBackpack(C[i], W[i]);
            } else {
                for (int k = 1; k < K[i]; k <<= 1) {
                    zeroOneBackpack(k * C[i], k * W[i]);
                    K[i] -= k;
                }
                zeroOneBackpack(K[i] * C[i], K[i] * W[i]);
            }
        }
        return dp[V];
    }

    private void zeroOneBackpack(int v, int w) {
        for (int j = V; j >= v; j--) dp[j] = Math.max(dp[j], dp[j - v] + w);
    }

    private void completedBackpack(int v, int w) {
        for (int j = v; j <= V; j++) dp[j] = Math.max(dp[j], dp[j - v] + w);
    }
}
