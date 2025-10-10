package knowledge.algorithms.dp.backpack.solution;

import knowledge.algorithms.dp.backpack.complete.CompletePack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 10/10/25 15:37
 */
public class Complete_one_path implements CompletePack {

    @Override
    public int backPack(int[] C, int[] W, int V) {
        int N = C.length;
        int[] dp = new int[V + 1];
        // choice[v] 记录容量为v时，达到最优解的最后一次选择是哪个物品
        int[] choice = new int[V + 1];
        Arrays.fill(choice, -1); // 初始化为-1，表示未做选择
        for (int i = 0; i < N; i++) {
            for (int v = C[i]; v <= V; v++) {
                if (dp[v - C[i]] + W[i] > dp[v]) {
                    dp[v] = dp[v - C[i]] + W[i];
                    choice[v] = i; // 记录这次成功的选择
                }
            }
        }
        // --- 输出结果 ---
        System.out.println("最大价值: " + dp[V]);
        System.out.println("其中一个最优方案:");
        Map<Integer, Integer> solution = new HashMap<>();
        int currentVolume = V;
        while (currentVolume > 0 && choice[currentVolume] != -1) {
            int itemIndex = choice[currentVolume];
            solution.put(itemIndex, solution.getOrDefault(itemIndex, 0) + 1);
            currentVolume -= C[itemIndex];
        }
        for (Map.Entry<Integer, Integer> entry : solution.entrySet()) {
            int idx = entry.getKey();
            System.out.println("物品" + idx + " (体积 " + C[idx] + ", 价值 " + W[idx] + ") × " + entry.getValue());
        }
        return dp[V];
    }
}
