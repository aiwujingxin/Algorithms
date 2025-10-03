package leetcode.problems;

import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/1 11:24
 */
public class LeetCode1466 {

    public int minReorder(int n, int[][] connections) {
        List<int[]>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] conn : connections) {
            int u = conn[0], v = conn[1];
            graph[u].add(new int[]{v, 1}); // 1 表示原始方向
            graph[v].add(new int[]{u, 0}); // 0 表示反向
        }
        boolean[] visited = new boolean[n];
        return dfs(graph, 0, visited);
    }

    private int dfs(List<int[]>[] graph, int u, boolean[] visited) {
        visited[u] = true;
        int count = 0;
        for (int[] v : graph[u]) {
            if (visited[v[0]]) continue;
            // 如果是从当前节点指向邻居节点的原始方向边，需要反转
            count += v[1] + dfs(graph, v[0], visited);
        }
        return count;
    }
}
