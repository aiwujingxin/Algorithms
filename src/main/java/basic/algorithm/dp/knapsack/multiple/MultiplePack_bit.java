package basic.algorithm.dp.knapsack.multiple;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/7 23:23
 * <a href="https://blog.51cto.com/acoier/5319246"></a>
 */
public class MultiplePack_bit {

    public int backPack(int capacity, int[] weight, int[] values, int[] amounts) {
        // 扁平化
        int N = weight.length;
        List<Integer> worth = new ArrayList<>();
        List<Integer> volume = new ArrayList<>();

        // 我们希望每件物品都进行扁平化，所以首先遍历所有的物品
        for (int i = 0; i < N; i++) {
            // 获取每件物品的出现次数
            int val = amounts[i];
            // 进行扁平化：如果一件物品规定的使用次数为 7 次，我们将其扁平化为三件物品：1*重量&1*价值、2*重量&2*价值、4*重量&4*价值
            // 三件物品都不选对应了我们使用该物品 0 次的情况、只选择第一件扁平物品对应使用该物品 1 次的情况、只选择第二件扁平物品对应使用该物品 2 次的情况，只选择第一件和第二件扁平物品对应了使用该物品 3 次的情况 ...
            for (int k = 1; k <= val; k *= 2) {
                val -= k;
                worth.add(values[i] * k);
                volume.add(weight[i] * k);
            }
            if (val > 0) {
                worth.add(values[i] * val);
                volume.add(weight[i] * val);
            }
        }

        // 0-1 背包问题解决方案
        int[] dp = new int[capacity + 1];
        for (int i = 0; i < worth.size(); i++) {
            for (int j = capacity; j >= volume.get(i); j--) {
                dp[j] = Math.max(dp[j], dp[j - volume.get(i)] + worth.get(i));
            }
        }
        return dp[capacity];
    }
}
