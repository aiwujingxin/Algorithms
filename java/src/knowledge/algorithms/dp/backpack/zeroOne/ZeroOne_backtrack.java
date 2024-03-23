package knowledge.algorithms.dp.backpack.zeroOne;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/27 00:17
 */
public class ZeroOne_backtrack implements ZeroOnePack {

    int ans;

    @Override
    public int backPack(int[] weight, int[] W, int V) {
        backtrack(0, weight, W, V, 0, 0);
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
        if (currentWeight + weights[index] <= capacity) {
            backtrack(index + 1, weights, values, capacity, currentWeight + weights[index], currentValue + values[index]);
        }
        backtrack(index + 1, weights, values, capacity, currentWeight, currentValue);
    }
}
