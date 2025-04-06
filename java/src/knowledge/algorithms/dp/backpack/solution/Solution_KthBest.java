package knowledge.algorithms.dp.backpack.solution;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wujingxinit@outlook.com
 * @date 4/7/25 02:00
 * @description 01背包 第 K 优解
 */

public class Solution_KthBest {

    public static int findKthBest(int[] weights, int[] values, int capacity, int K) {
        // dp[j] 保存容量j时的前K优解
        List<Integer>[] dp = new ArrayList[capacity + 1];

        // 初始化
        for (int j = 0; j <= capacity; j++) {
            dp[j] = new ArrayList<>();
            dp[j].add(0); // 初始化为0价值（不选任何物品）
        }

        for (int i = 0; i < weights.length; i++) {
            for (int j = capacity; j >= weights[i]; j--) {
                // 合并两种情况：选当前物品和不选当前物品
                // 不选当前物品
                List<Integer> temp = new ArrayList<>(dp[j]);
                for (int val : dp[j - weights[i]]) {
                    temp.add(val + values[i]); // 选当前物品
                }
                // 去重、排序并保留前K大
                dp[j] = temp.stream().distinct().sorted(Collections.reverseOrder()).limit(K).collect(Collectors.toList());
            }
        }

        // 返回第K优解（如果存在）
        return dp[capacity].size() >= K ? dp[capacity].get(K - 1) : -1;
    }

    public static void main(String[] args) {
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int capacity = 8;
        int K = 3;

        int result = findKthBest(weights, values, capacity, K);
        System.out.println("第" + K + "优解的价值: " + result);
    }
}

