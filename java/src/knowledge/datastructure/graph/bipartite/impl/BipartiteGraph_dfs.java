package knowledge.datastructure.graph.bipartite.impl;

import knowledge.datastructure.graph.bipartite.BipartiteGraph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/19 23:31
 */
public class BipartiteGraph_dfs implements BipartiteGraph {

    List<Integer>[] graph;
    int[] colors;

    public boolean isBipartite(int n, int[][] edges) {
        graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[1]].add(edge[0]);
            graph[edge[0]].add(edge[1]);
        }
        colors = new int[n];
        for (int i = 0; i < n; i++) {
            if (colors[i] == 0 && !dfs(i, 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int u, int c) {
        if (colors[u] != 0) {
            return colors[u] == c;
        }
        colors[u] = c;
        for (int v : graph[u]) {
            if (!dfs(v, -c)) {
                return false;
            }
        }
        return true;
    }
}
