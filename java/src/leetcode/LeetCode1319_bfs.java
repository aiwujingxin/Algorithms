package leetcode;

import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/23 00:06
 * Complexity:
 * <p>
 * Time: O(n+m), m is the length of connections
 * Space: O(n)
 * <a href="https://leetcode.com/problems/number-of-operations-to-make-network-connected/discuss/1395262/java-clean-bfs-solution-easy-to-understand">...</a>
 */
public class LeetCode1319_bfs {

    public int makeConnected(int n, int[][] connections) {
        // To connect all nodes need at least n-1 edges
        if (connections.length < n - 1) {
            return -1;
        }

        // build graph
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] c : connections) {
            graph[c[0]].add(c[1]);
            graph[c[1]].add(c[0]);
        }
        // count components
        int components = 0;
        boolean[] visited = new boolean[n];
        for (int v = 0; v < n; v++) {
            components += bfs(v, graph, visited);
        }
        // Need (components-1) cables to connect components together
        return components - 1;
    }

    int bfs(int src, List<Integer>[] graph, boolean[] visited) {
        if (visited[src]) {
            return 0;
        }
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
