package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/4 23:16
 */
public class LeetCode1377 {

    public double frogPosition(int n, int[][] edges, int t, int target) {
        List<Integer>[] graph = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[1].add(0); // 减少额外判断的小技巧
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        long res = dfs(graph, 1, 0, t, target);
        return res != 0 ? 1.0 / res : 0;
    }

    private long dfs(List<Integer>[] graph, int node, int fa, int t, int target) {
        if (t == 0) {
            return node == target ? 1 : 0;
        }
        if (node == target) {
            return graph[node].size() == 1 ? 1 : 0;
        }
        long ans = 0;
        for (Integer next : graph[node]) {
            if (next != fa) {
                ans += dfs(graph, next, node, t - 1, target);
                if (ans != 0) {
                    return ans * (graph[node].size() - 1);
                }
            }
        }
        return 0;
    }
}
