package knowledge.dp.backpack.lintcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/7 22:17
 * @description 01背包 最大体积
 * @link <a href="https://www.lintcode.com/problem/92/">Backpack</a>
 * 在 n 个物品中挑选若干物品装入背包，最多能装多满？
 * 假设背包的大小为m，每个物品的大小为A[i]（每个物品只能选择一次且物品大小均为正整数）
 */
public class BackpackI {

    public int backPack(int V, int[] A) {
        int N = A.length;
        int[] dp = new int[V + 1];
        for (int i = 0; i < N; i++) {
            for (int v = V; v >= A[i]; v--) {
                dp[v] = Math.max(dp[v], dp[v - A[i]] + A[i]);
            }
        }
        return dp[V];
    }
}
