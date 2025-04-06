package knowledge.algorithms.dp.backpack.solution;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 4/7/25 02:12
 * @description 01背包 输出最优方案
 */
public class Solution {

    public static void printAllSolutions(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[] dp = new int[capacity + 1];
        List<List<Integer>>[] solutions = new ArrayList[capacity + 1];

        // 初始化
        for (int i = 0; i <= capacity; i++) {
            solutions[i] = new ArrayList<>();
            solutions[i].add(new ArrayList<>()); // 不选任何物品的方案
        }

        for (int i = 0; i < n; i++) {
            for (int j = capacity; j >= weights[i]; j--) {
                int newValue = dp[j - weights[i]] + values[i];

                if (newValue > dp[j]) {
                    // 发现更优解，更新dp和方案列表
                    dp[j] = newValue;
                    solutions[j] = new ArrayList<>();
                    for (List<Integer> sol : solutions[j - weights[i]]) {
                        List<Integer> newSol = new ArrayList<>(sol);
                        newSol.add(i);
                        solutions[j].add(newSol);
                    }
                } else if (newValue == dp[j]) {
                    // 价值相同，合并方案
                    for (List<Integer> sol : solutions[j - weights[i]]) {
                        List<Integer> newSol = new ArrayList<>(sol);
                        newSol.add(i);
                        solutions[j].add(newSol);
                    }
                }
            }
        }

        // 输出结果
        System.out.println("最大价值: " + dp[capacity]);
        System.out.println("方案数量: " + solutions[capacity].size());
        System.out.println("具体方案:");
        for (List<Integer> sol : solutions[capacity]) {
            System.out.println("  选择物品: " + sol +
                    " 总重量: " + calculateTotalWeight(sol, weights) +
                    " 总价值: " + dp[capacity]);
        }
    }

    private static int calculateTotalWeight(List<Integer> items, int[] weights) {
        return items.stream().mapToInt(i -> weights[i]).sum();
    }

    public static void main(String[] args) {
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int capacity = 8;
        printAllSolutions(weights, values, capacity);
    }
}
