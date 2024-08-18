package knowledge.algorithms.dp.backpack.multiple;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/22 12:38
 */
public class Multiple_bk implements MultiplePack {

    int max = 0;

    public int backPack(int[] weight, int[] value, int[] N, int capacity) {
        max = 0;
        backtrack(weight, value, N, capacity, 0, 0, 0);
        return max;
    }

    private void backtrack(int[] weight, int[] value, int[] count, int capacity, int index, int currentWeight, int currentValue) {
        if (index == weight.length) {
            max = Math.max(max, currentValue);
            return;
        }
        for (int i = 0; i <= count[index]; i++) {
            if (currentWeight + weight[index] * i <= capacity) {
                backtrack(weight, value, count, capacity, index + 1, currentWeight + weight[index] * i, currentValue + value[index] * i);
            }
        }
    }
}
