package knowledge.dp.backpack.multiple;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/7 23:59
 * @description 转化为01背包。 则需要从大到小
 */
public class Multiple_dp_1d implements MultiplePack {

    public int backPack(int[] C, int[] W, int[] S, int V) {
        int N = W.length;
        int[] dp = new int[V + 1];
        for (int i = 0; i < N; i++) {
            for (int v = V; v >= 0; v--) {
                // k 做决策
                for (int k = 0; k <= S[i] && v >= k * C[i]; k++) {
                    dp[v] = Math.max(dp[v], dp[v - k * C[i]] + k * W[i]);
                }
            }
        }
        return dp[V];
    }

    public int backPack_v2(int[] C, int[] W, int[] M, int V) {
        int N = W.length;
        int[] dp = new int[V + 1];
        for (int i = 0; i < N; i++) {
            for (int k = 1; k <= M[i]; k++) {
                for (int v = V; v >= C[i]; v--) {
                    dp[v] = Math.max(dp[v], dp[v - C[i]] + W[i]);
                }
            }
        }
        return dp[V];
    }

    public int backPack_v3(int[] C, int[] W, int[] S, int V) {
        int n = C.length;
        List<Integer> value = new ArrayList<>();
        List<Integer> weights = new ArrayList<>();

        // 我们希望每件物品都进行扁平化，所以首先遍历所有的物品
        for (int i = 0; i < n; i++) {
            // 获取每件物品的出现次数
            int cnt = S[i];
            for (int k = 1; k <= cnt; k *= 2) {
                cnt -= k;
                value.add(W[i] * k);
                weights.add(C[i] * k);
            }
            if (cnt > 0) {
                value.add(W[i] * cnt);
                weights.add(C[i] * cnt);
            }
        }
        // 0-1 背包问题解决方案
        int[] dp = new int[V + 1];
        for (int i = 0; i < value.size(); i++) {
            for (int j = V; j >= weights.get(i); j--) {
                dp[j] = Math.max(dp[j], dp[j - weights.get(i)] + value.get(i));
            }
        }
        return dp[V];
    }
}
