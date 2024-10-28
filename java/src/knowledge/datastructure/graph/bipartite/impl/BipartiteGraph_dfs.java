package knowledge.datastructure.graph.bipartite.impl;

import knowledge.datastructure.graph.bipartite.BipartiteGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/19 23:31
 */
public class BipartiteGraph_dfs implements BipartiteGraph {

    List<Integer>[] graph;

    public boolean isBipartite(int n, int[][] edges) {
        graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[1]].add(edge[0]);
            graph[edge[0]].add(edge[1]);
        }
        int[] colors = new int[n];
        Arrays.fill(colors, -1);
        for (int i = 0; i < n; i++) {
            if (colors[i] == -1) {
                if (!dfs(i, colors, 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int v, int[] colors, int color) {
        colors[v] = color;
        for (int neighbor : graph[v]) {
            if (colors[neighbor] == color) {
                return false;
            }
            if (colors[neighbor] == -1 && !dfs(neighbor, colors, 1 - color)) {
                return false;
            }
        }
        return true;
    }
}
