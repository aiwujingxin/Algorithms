package knowledge.dp.backpack.multiple;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/7 23:23
 * @link <a href="https://blog.51cto.com/acoier/5319246"></a>
 */
public class Multiple_bit_v1 implements MultiplePack {

    public int backPack(int[] C, int[] W, int[] S, int V) {
        int n = C.length;
        int[] dp = new int[V + 1]; // 动态规划数组
        for (int i = 0; i < n; i++) {
            int c = S[i]; // 当前物品数量
            for (int k = 1; c > 0; k <<= 1) { // 使用二进制优化
                int mul = Math.min(k, c); // 当前物品数量使用个数
                c -= mul; // 更新剩余数量
                for (int j = V; j >= C[i] * mul; j--) {
                    dp[j] = Math.max(dp[j], dp[j - C[i] * mul] + W[i] * mul);
                }
            }
        }
        return dp[V];
    }
}
