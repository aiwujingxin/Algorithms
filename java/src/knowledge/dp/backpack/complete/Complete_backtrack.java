package knowledge.dp.backpack.complete;


/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/25 15:27
 */
public class Complete_backtrack implements CompletePack {

    int ans;

    public int backPack(int[] weights, int[] values, int capacity) {
        backtrack(0, weights, values, capacity, 0, 0);
        return ans;
    }

    public void backtrack(int index, int[] weights, int[] values, int capacity, int currentWeight, int currentValue) {
        if (currentWeight > capacity) {
            return;
        }
        if (index >= weights.length) {
            if (currentValue > ans) {
                ans = currentValue;
            }
            return;
        }

        // 选当前物品，可以选择0次～多次
        for (int i = 0; i <= (capacity - currentWeight) / weights[index]; i++) {
            backtrack(index + 1, weights, values, capacity, currentWeight + i * weights[index], currentValue + i * values[index]);
        }
    }
}
