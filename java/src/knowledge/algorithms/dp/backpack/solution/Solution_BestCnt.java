package knowledge.algorithms.dp.backpack.solution;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 4/7/25 02:04
 * @description 01背包 最优方案数
 */
public class Solution_BestCnt {

    public static int[] countMaxValueSolutions(int[] weights, int[] values, int capacity) {
        int[] dp = new int[capacity + 1];
        int[] count = new int[capacity + 1];
        Arrays.fill(count, 1); // 初始化为1，表示不选任何物品是一种方案

        for (int i = 0; i < weights.length; i++) {
            for (int j = capacity; j >= weights[i]; j--) {
                if (dp[j - weights[i]] + values[i] > dp[j]) {
                    // 找到更大的价值，更新dp和count
                    dp[j] = dp[j - weights[i]] + values[i];

                    count[j] = count[j - weights[i]];
                } else if (dp[j - weights[i]] + values[i] == dp[j]) {
                    // 价值相同，方案数累加
                    count[j] += count[j - weights[i]];
                }
            }
        }
        return new int[]{dp[capacity], count[capacity]};
    }
}
