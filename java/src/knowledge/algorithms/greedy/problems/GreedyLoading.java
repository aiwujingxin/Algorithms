package knowledge.algorithms.greedy.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 4/20/25 23:39
 * @description 最优装载问题 给定 n 个物品，每个物品的重量为w，货船的最大载重为C。
 * 在不超过载重的前提下，选择尽可能多的物品装上船。
 * <变种问题>（可参考算法导论相关章节）
 * 📦 多个货船（分组背包问题）
 * 💰 每个物品有价值（转为性价比贪心 或 0/1 背包）
 * 🧠 想装总重量最大（用动态规划）
 * 🔄 装最多种类的物品（类比区间调度）
 */
public class GreedyLoading {

    public int maxItems(int[] weights, int capacity) {
        Arrays.sort(weights); // 按重量升序排序（贪心核心）
        int total = 0;
        int count = 0;
        for (int w : weights) {
            if (total + w <= capacity) {
                total += w;
                count++;
            } else {
                break; // 装不下了
            }
        }
        return count;
    }
}
