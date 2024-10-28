package knowledge.datastructure.graph.bipartite.impl;

import knowledge.datastructure.graph.bipartite.BipartiteGraph;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/19 23:23
 */

public class BipartiteGraph_bfs implements BipartiteGraph {

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
                if (!bfs(i, colors)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean bfs(int s, int[] colors) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        colors[s] = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph[cur]) {
                if (colors[next] == -1) {
                    colors[next] = 1 - colors[cur];
                    q.add(next);
                } else if (colors[next] == colors[cur]) {
                    return false;
                }
            }
        }
        return true;
    }
}
