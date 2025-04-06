package knowledge.algorithms.dp.backpack.solution;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wujingxinit@outlook.com
 * @date 4/7/25 02:00
 * @description 01背包 次优解
 */

public class Solution_SecondBest {

    public int[] secondBestKnapsack(int[] weights, int[] values, int capacity) {
        int[] dp1 = new int[capacity + 1]; // 最优解
        int[] dp2 = new int[capacity + 1]; // 次优解
        Arrays.fill(dp2, -1); // 初始化为-1表示不可行

        for (int i = 0; i < weights.length; i++) {
            for (int j = capacity; j >= weights[i]; j--) {
                int include = dp1[j - weights[i]] + values[i];

                // 更新最优和次优
                if (include > dp1[j]) {
                    dp2[j] = dp1[j]; // 原最优变为次优
                    dp1[j] = include;
                } else if (include > dp2[j]) {
                    dp2[j] = include;
                }

                // 保持次优解的有效性
                if (dp2[j - weights[i]] != -1) {
                    int includeSecond = dp2[j - weights[i]] + values[i];
                    if (includeSecond > dp2[j]) {
                        dp2[j] = includeSecond;
                    }
                }
            }
        }
        return new int[]{dp1[capacity], dp2[capacity]};
    }


    public int secondBestWithTracking(int[] weights, int[] values, int capacity) {
        List<Integer>[] dp = new ArrayList[capacity + 1];
        for (int i = 0; i <= capacity; i++) {
            dp[i] = new ArrayList<>();
            dp[i].add(0); // 初始0价值
        }

        for (int i = 0; i < weights.length; i++) {
            for (int j = capacity; j >= weights[i]; j--) {
                List<Integer> newValues = new ArrayList<>();
                for (int val : dp[j - weights[i]]) {
                    newValues.add(val + values[i]);
                }

                // 合并并保留前二
                dp[j] = mergeAndKeepTop2(dp[j], newValues);
            }
        }

        return dp[capacity].size() > 1 ? dp[capacity].get(1) : 0;
    }

    List<Integer> mergeAndKeepTop2(List<Integer> list1, List<Integer> list2) {
        List<Integer> merged = new ArrayList<>();
        merged.addAll(list1);
        merged.addAll(list2);
        merged = merged.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        return merged.subList(0, Math.min(2, merged.size()));
    }
}

