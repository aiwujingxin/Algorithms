package knowledge.dp.backpack.multiple;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/7 23:59
 */
public class Multiple_dp_1d implements MultiplePack{

    public int backPack(int[] weights, int[] values, int[] counts, int capacity) {
        int n = values.length;
        int[] dp = new int[capacity + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < counts[i]; j++) {
                for (int k = capacity; k >= weights[i]; k--) {
                    dp[k] = Math.max(dp[k], dp[k - weights[i]] + values[i]);
                }
            }
        }
        return dp[capacity];
    }
}
