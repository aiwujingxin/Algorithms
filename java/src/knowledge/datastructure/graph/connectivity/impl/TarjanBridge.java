package knowledge.datastructure.graph.connectivity.impl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 10/31/24 22:54
 * @description 割边
 */
public class TarjanBridge {

    private List<Integer>[] graph;
    private List<int[]> bridges;
    private int[] dfn;
    private int[] low;
    private boolean[] vis;
    private int time;

    public List<int[]> findBridges(int n, List<Integer>[] graph) {
        this.graph = graph;
        this.bridges = new ArrayList<>();
        this.dfn = new int[n];
        this.low = new int[n];
        this.vis = new boolean[n];
        this.time = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, i);
            }
        }
        return bridges;
    }

    private void dfs(int u, int pa) {
        vis[u] = true;
        dfn[u] = low[u] = ++time;
        for (int v : graph[u]) {
            if (!vis[v]) {
                dfs(v, u);
                low[u] = Math.min(low[u], low[v]);
                if (pa != u && low[v] > dfn[u]) {
                    bridges.add(new int[]{u, v});
                }
            } else if (dfn[v] < dfn[u] && v != pa) {
                low[u] = Math.min(low[u], dfn[v]);
            }
        }
    }

    public static void main(String[] args) {
        int V = 10;
        List<Integer>[] graph = new List[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
        int[][] edges = {
                {0, 1}, {1, 2}, {0, 3}, {1, 4}, {3, 4},
                {4, 5}, {4, 6}, {6, 7}, {7, 8}, {7, 9}
        };
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        List<int[]> bridges = new TarjanBridge().findBridges(V, graph);
        System.out.println("割边:");
        for (int[] bridge : bridges) {
            System.out.println(bridge[0] + " - " + bridge[1]);
        }
    }
}