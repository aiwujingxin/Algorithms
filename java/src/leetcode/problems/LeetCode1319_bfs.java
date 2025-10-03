package leetcode.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/23 00:06
 */
public class LeetCode1319_bfs {

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
        for (int v = 0; v < n; v++) {
            components += bfs(v, graph, visited);
        }
        return components - 1;
    }

    int bfs(int src, List<Integer>[] graph, boolean[] visited) {
        if (visited[src]) return 0;
        visited[src] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : graph[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.offer(v);
                }
            }
        }
        return 1;
    }
}
