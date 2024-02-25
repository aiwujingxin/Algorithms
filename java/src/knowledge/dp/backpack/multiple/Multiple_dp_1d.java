package knowledge.dp.backpack.multiple;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/7 23:59
 */
public class Multiple_dp_1d {

    public int backPack(int capacity, int[] weight, int[] values, int[] amounts) {
        int n = values.length;
        int[] dp = new int[capacity + 1];
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < amounts[i]; j++) {
                for (int k = capacity; k >= weight[i]; k--) {
                    dp[k] = Math.max(dp[k], dp[k - weight[i]] + values[i]);
                }
            }
        }
        return dp[capacity];
    }
}
