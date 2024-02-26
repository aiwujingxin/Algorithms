package knowledge.dp.backpack.multiple;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/26 22:58
 */
public class Multiple_bit_v2 implements MultiplePack {

    int[] dp;
    int V;

    public int backPack(int[] C, int[] W, int[] S, int V) {
        int N = C.length;
        this.dp = new int[V + 1];
        this.V = V;
        for (int i = 0; i < N; i++) {
            if (C[i] * S[i] > V) {
                completedBackpack(C[i], W[i]);
            } else {
                int k = 1;
                while (k < S[i]) {
                    zeroOneBackpack(k * C[i], k * W[i]);
                    S[i] -= k;
                    k <<= 1;    // 二进制的思想
                }
                zeroOneBackpack(S[i] * C[i], S[i] * W[i]);
            }
        }
        return dp[V];
    }

    private void zeroOneBackpack(int C, int W) {
        for (int j = V; j >= C; j--) {
            dp[j] = Math.max(dp[j], dp[j - C] + W);
        }
    }

    private void completedBackpack(int C, int W) {
        for (int j = C; j <= V; j++) {
            dp[j] = Math.max(dp[j], dp[j - C] + W);
        }
    }
}
