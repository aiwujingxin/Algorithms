package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 7/28/26 14:15
 */
public class LeetCode787_dfs {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // 1. 构建 List<int[]>[] graph
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int price = flight[2];
            graph[u].add(new int[]{v, price});
        }
        // 2. 初始化 memo 数组
        // k 站中转，意味着最多可以走 k + 1 条边
        Integer[][] memo = new Integer[n][k + 2];
        // 3. 执行 DFS
        int ans = dfs(src, k + 1, dst, graph, memo);
        // 4. 返回结果
        return ans == Integer.MAX_VALUE / 2 ? -1 : ans;
    }

    private int dfs(int node, int edges, int dst, List<int[]>[] graph, Integer[][] memo) {
        // 到达目的地，花费为 0
        if (node == dst) return 0;
        // 边数用尽，仍未到达目的地，返回不可达
        if (edges == 0) return Integer.MAX_VALUE / 2;
        // 如果已经计算过，直接返回备忘录中的值
        if (memo[node][edges] != null) return memo[node][edges];
        int minPrice = Integer.MAX_VALUE / 2;
        // 遍历所有邻居节点
        for (int[] neighbor : graph[node]) {
            int nextNode = neighbor[0];
            int price = neighbor[1];
            // 递归计算从下一个节点出发的最小花费
            int cost = dfs(nextNode, edges - 1, dst, graph, memo);
            minPrice = Math.min(minPrice, cost + price);
        }
        // 记录状态并返回
        memo[node][edges] = minPrice;
        return minPrice;
    }
}
