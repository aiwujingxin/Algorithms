package knowledge.algorithms.dp.backpack.solution;

import knowledge.algorithms.dp.backpack.complete.CompletePack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 10/10/25 15:37
 */
public class Complete_all_path implements CompletePack {

    @Override
    public int backPack(int[] C, int[] W, int V) {
        int N = C.length;
        int[] dp = new int[V + 1];
        // allPath[v] 存储容量为v时所有最优组合
        List<Map<Integer, Integer>>[] allPath = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++) {
            allPath[i] = new ArrayList<>();
        }
        allPath[0].add(new HashMap<>()); // 容量0有一种方案：空组合
        for (int i = 0; i < N; i++) {
            for (int v = C[i]; v <= V; v++) {
                int newVal = dp[v - C[i]] + W[i];
                if (newVal > dp[v]) {
                    dp[v] = newVal;
                    allPath[v].clear(); // 清空旧方案
                    expandAndAdd(allPath[v - C[i]], allPath[v], i);
                } else if (newVal == dp[v]) {
                    expandAndAdd(allPath[v - C[i]], allPath[v], i);
                }
            }
        }
        // --- 输出结果 ---
        System.out.println("最大价值: " + dp[V]);
        System.out.println("所有达到最大价值的方案 (" + allPath[V].size() + "种):");
        for (Map<Integer, Integer> comb : allPath[V]) {
            System.out.print("  组合: ");
            if (comb.isEmpty()) {
                System.out.print("空");
            } else {
                comb.forEach((idx, cnt) -> System.out.print("物品" + idx + " (V:" + C[idx] + ",W:" + W[idx] + ")×" + cnt + "  "));
            }
            System.out.println();
        }
        return dp[V];
    }

    // 公共方法：将fromList中的每个组合添加一个物品i后，存入toList
    private void expandAndAdd(List<Map<Integer, Integer>> fromList, List<Map<Integer, Integer>> toList, int itemIndex) {
        for (Map<Integer, Integer> comb : fromList) {
            Map<Integer, Integer> newComb = new HashMap<>(comb);
            newComb.put(itemIndex, newComb.getOrDefault(itemIndex, 0) + 1);
            toList.add(newComb);
        }
    }
}
