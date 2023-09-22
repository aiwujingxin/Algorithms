package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/30 15:25
 */
public class LeetCode1059 {

    HashMap<Integer, List<Integer>> adj = new HashMap<>();
    int destination;
    boolean[] onPath;
    boolean[] visited;

    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }
        this.onPath = new boolean[n];
        this.visited = new boolean[n];
        this.destination = destination;
        return dfs(source);
    }

    private boolean dfs(int source) {
        if (adj.get(source).isEmpty()) {
            return source == destination;
        }
        visited[source] = true;
        onPath[source] = true;
        for (int next : adj.get(source)) {
            if (onPath[next]) {
                return false;
            }
            if (!visited[next]) {
                if (!dfs(next)) {
                    return false;
                }
            }
        }
        onPath[source] = false;
        return true;
    }
}
