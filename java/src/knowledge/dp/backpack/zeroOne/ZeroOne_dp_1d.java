package knowledge.dp.backpack.zeroOne;


/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/13 12:37
 */
public class ZeroOne_dp_1d implements ZeroOnePack {

    @Override
    public int backPack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[] dp = new int[capacity + 1];
        for (int i = 1; i <= n; i++) {
            //滚动数组 逆序实现
            for (int j = capacity; j >= weights[i - 1]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weights[i - 1]] + values[i - 1]);
            }
        }
        return dp[capacity];
    }
}
