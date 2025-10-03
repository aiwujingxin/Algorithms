package knowledge.algorithms.dp.backpack.multiple.problems;

import knowledge.algorithms.dp.backpack.multiple.MultiplePack;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/26 22:58
 * @description 多重背包 二进制优化 O(N⋅V⋅logK)
 * 核心思想：将每种物品的数量s_i拆分成1, 2, 4, ..., 2^(k-1), k_i - (2^k-1）的组合
 * 优势：通过这种拆分，可以用log(s_i)个"新物品"来表示原来s_i个物品的所有可能选择
 * 效果：将时间复杂度从O(N×V×K)降低到O(N×V×logK)
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
                 /*
                如果全装进去已经超了总金额，相当于这个物品就是无限的
                因为是取不光的，那么就用完全背包去套
                 */
                completedBackpack(C[i], W[i]);
            } else {
                /*
                    取得光的话，去遍历每种取法
                    这里用到是二进制思想，降低了复杂度
                    为什么呢，因为他取的1,2,4,8...与余数个该物品，打包成一个大型的该物品
                    这样足够凑出了从0-k个该物品取法
                    把复杂度从k变成了logk
                    如k=11，则有1,2,4,4，足够凑出0-11个该物品的取法
                 */
                for (int k = 1; k < K[i]; k <<= 1) {
                    zeroOneBackpack(k * C[i], k * W[i]);
                    K[i] -= k;
                }
                // 最后对余数部分进行一次 01背包 处理
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
