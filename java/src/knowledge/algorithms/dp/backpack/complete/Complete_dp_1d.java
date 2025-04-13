package knowledge.algorithms.dp.backpack.complete;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/18 12:33
 */
public class Complete_dp_1d implements CompletePack {

    @Override
    public int backPack(int[] C, int[] W, int V) {
        int N = C.length;
        int[] dp = new int[V + 1];
        int[] path = new int[V + 1]; // path[v] 表示容量 v 的最优解最后加入的物品编号

        // allPath[v] 表示容量为 v 时所有达到最大价值的组合
        List<Map<Integer, Integer>>[] allPath = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++) allPath[i] = new ArrayList<>();
        allPath[0].add(new HashMap<>()); // 初始：容量为 0 只有一个空组合
        for (int i = 0; i < N; i++) { // 物品
            for (int v = C[i]; v <= V; v++) { // 体积
                int newVal = dp[v - C[i]] + W[i];
                if (newVal > dp[v]) {
                    dp[v] = newVal;
                    path[v] = i; // 记录转移来自哪个物品

                    allPath[v] = new ArrayList<>();
                    for (Map<Integer, Integer> comb : allPath[v - C[i]]) {
                        Map<Integer, Integer> newComb = new HashMap<>(comb);
                        newComb.put(i, newComb.getOrDefault(i, 0) + 1);
                        allPath[v].add(newComb);
                    }
                } else if (newVal == dp[v]) {
                    // 同样优，追加组合
                    for (Map<Integer, Integer> comb : allPath[v - C[i]]) {
                        Map<Integer, Integer> newComb = new HashMap<>(comb);
                        newComb.put(i, newComb.getOrDefault(i, 0) + 1);
                        allPath[v].add(newComb);
                    }

                }
            }
        }
        // 输出一个最优方案
        System.out.println("最大价值: " + dp[V]);
        System.out.println("其中一个最优方案:");
        int cur = V;
        Map<Integer, Integer> count = new HashMap<>();
        while (cur > 0 && path[cur] != -1) {
            int item = path[cur];
            count.put(item, count.getOrDefault(item, 0) + 1);
            cur -= C[item];
        }
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int idx = entry.getKey();
            System.out.println("物品" + idx + "（体积 " + C[idx] + ", 价值 " + W[idx] + "）× " + entry.getValue());
        }

        // 输出所有方案
        System.out.println("最大价值: " + dp[V]);
        System.out.println("所有达到最大价值的方案：");
        for (Map<Integer, Integer> comb : allPath[V]) {
            System.out.print("组合: ");
            for (Map.Entry<Integer, Integer> entry : comb.entrySet()) {
                int idx = entry.getKey();
                int cnt = entry.getValue();
                System.out.print("物品" + idx + "（体积 " + C[idx] + ", 价值 " + W[idx] + "）×" + cnt + "  ");
            }
            System.out.println();
        }
        return dp[V];
    }
}
