package basicKnowledge.algorithm.dynamicProgramming.knapsack.complete;

import basicKnowledge.algorithm.dynamicProgramming.knapsack.Knapsack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/25 15:27
 */
public class CompletePack_backtrack implements Knapsack {

    int max = 0; // 用于记录最大价值

    public int backPack(int[] weights, int[] values, int capacity) {
        backtrack(weights, values, capacity, 0, 0, 0);
        return max;
    }

    public void backtrack(int[] weights, int[] values, int capacity, int currentWeight, int currentValue, int index) {
        if (index >= weights.length) {
            if (currentWeight <= capacity && currentValue > max) {
                max = currentValue;
            }
            return;
        }
        // 不选当前物品
        backtrack(weights, values, capacity, currentWeight, currentValue, index + 1);
        // 选当前物品，可以选择多次
        for (int i = 1; i <= (capacity - currentWeight) / weights[index]; i++) {
            backtrack(weights, values, capacity, currentWeight + i * weights[index], currentValue + i * values[index], index + 1);
        }
    }
}
