package knowledge.algorithms.dp.backpack.group;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/4 10:34
 * @description 分组背包 空间优化
 */
public class GroupPack_dp_1d implements GroupPack {

    public int backPack(int N, int V, int[] K, int[][] C, int[][] W) {
        int[] dp = new int[V + 1];
        for (int i = 0; i < N; i++) { // 物品
            for (int v = V; v >= 0; v--) {  // 容量 逆序
                for (int k = 0; k < K[i] && v >= C[i][k]; k++) { // 组内物品
                    dp[v] = Math.max(dp[v], dp[v - C[i][k]] + W[i][k]);
                }
            }
        }
        return dp[V];
    }
}
