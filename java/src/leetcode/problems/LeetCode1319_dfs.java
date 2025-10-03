package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/23 22:10
 * @see LeetCode200
 */
public class LeetCode1319_dfs {

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] c : connections) {
            graph[c[0]].add(c[1]);
            graph[c[1]].add(c[0]);
        }
        int components = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            dfs(i, graph, visited);
            components++;
        }
        return components - 1;
    }

    void dfs(int u, List<Integer>[] graph, boolean[] visited) {
        if (visited[u]) return;
        visited[u] = true;
        for (int v : graph[u]) dfs(v, graph, visited);
    }
}
