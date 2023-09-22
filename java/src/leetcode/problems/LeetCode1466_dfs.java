package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/1 12:44
 */
public class LeetCode1466_dfs {
    public int minReorder(int n, int[][] connections) {
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] connection : connections) {
            // 1 denotes original edge
            graph.get(connection[0]).add(new Edge(connection[1], 1));

            // 0 denotes reversed edge
            graph.get(connection[1]).add(new Edge(connection[0], 0));
        }

        // Run a dfs from 0 and dissolve(mark) the edges that can be reached from zero, thereby increasing the count
        // Because if an edge is directly reachable from 0, it actually needs to get reversed
        return dfs(graph, 0, new boolean[n]);
    }

    // DFS
    private int dfs(List<List<Edge>> graph, int source, boolean[] isVisited) {
        int cost = 0;
        isVisited[source] = true;

        for (Edge neighbour : graph.get(source)) {
            if (!isVisited[neighbour.vertex]) {
                cost += neighbour.count + dfs(graph, neighbour.vertex, isVisited);
            }
        }
        return cost;
    }

    private static class Edge {
        int vertex, count;

        public Edge(int vertex, int count) {
            this.vertex = vertex;
            this.count = count;
        }
    }
}
