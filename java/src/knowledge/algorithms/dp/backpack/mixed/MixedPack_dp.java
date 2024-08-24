package knowledge.algorithms.dp.backpack.mixed;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/29 23:14
 * @link <a href="https://www.acwing.com/solution/content/53633/"></a>
 */
public class MixedPack_dp implements MixedPack {

    int m;
    int[] f;

    @Override
    public int backPack(int[] C, int[] W, int[] S, int[] T, int V) {
        int n = C.length;
        this.m = V;
        this.f = new int[V + 1];
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
        return f[V];
    }

    private void zeroOneBackpack(int v, int w) {
        for (int j = m; j >= v; j--) f[j] = Math.max(f[j], f[j - v] + w);
    }

    private void completedPack(int v, int w) {
        for (int j = v; j <= m; j++) f[j] = Math.max(f[j], f[j - v] + w);
    }

}
