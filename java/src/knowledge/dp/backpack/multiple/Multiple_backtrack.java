package knowledge.dp.backpack.multiple;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/22 12:38
 */
public class Multiple_backtrack {

    public boolean backPack(int capacity, int[] weight, int[] amounts) {
        return dfs(0, 0, weight, amounts, capacity);
    }

    private boolean dfs(int depth, int sum, int[] weight, int[] amounts, int target) {
        if (sum == target) {
            return true;
        }
        if (sum > target || depth == weight.length) {
            return false;
        }
        for (int i = 0; i <= amounts[depth]; i++) {
            sum += weight[depth] * i;
            if (dfs(depth + 1, sum, weight, amounts, target)) {
                return true;
            }
            sum -= weight[depth] * i;
        }
        return false;
    }
}
