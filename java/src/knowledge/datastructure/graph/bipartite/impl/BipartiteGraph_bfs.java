package knowledge.datastructure.graph.bipartite.impl;

import knowledge.datastructure.graph.bipartite.BipartiteGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/19 23:23
 */

public class BipartiteGraph_bfs implements BipartiteGraph {

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
        this.colors = new int[n];
        for (int i = 0; i < n; i++) {
            if (colors[i] == 0 && !bfs(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean bfs(int s) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        colors[s] = 1;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : graph[u]) {
                if (colors[v] == 0) {
                    colors[v] = -colors[u];
                    q.add(v);
                } else if (colors[v] == colors[u]) {
                    return false;
                }
            }
        }
        return true;
    }
}
