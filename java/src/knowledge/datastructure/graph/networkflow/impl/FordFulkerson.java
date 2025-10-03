package knowledge.datastructure.graph.networkflow.impl;

import knowledge.datastructure.graph.networkflow.MaxFlow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/3 13:21
 */
public class FordFulkerson implements MaxFlow {

    private int V;
    private List<List<Edge>> g;

    public FordFulkerson() {
    }

    public FordFulkerson(int V) {
        this.V = V;
        g = new ArrayList<>(V);
        for (int i = 0; i < V; i++) g.add(new ArrayList<>());
    }

    public int maxFlow(int n, int[][] edges) {
        int S = 2 * n, T = 2 * n + 1, V = 2 * n + 2;
        FordFulkerson ff = new FordFulkerson(V);
        for (int u = 0; u < n; u++) ff.addEdge(S, u, 1);
        for (int[] e : edges) ff.addEdge(e[0], n + e[1], 1);
        for (int v = 0; v < n; v++) ff.addEdge(n + v, T, 1);
        return ff.maxFlow(S, T);
    }

    public void addEdge(int u, int v, int capacity) {
        Edge a = new Edge(v, g.get(v).size(), capacity);
        Edge b = new Edge(u, g.get(u).size(), 0);
        g.get(u).add(a);
        g.get(v).add(b);
    }

    private int dfs(int u, int t, int f, boolean[] vis) {
        if (u == t) return f;
        vis[u] = true;
        for (Edge e : g.get(u)) {
            if (e.residual() > 0 && !vis[e.to]) {
                int pushed = dfs(e.to, t, Math.min(f, e.residual()), vis);
                if (pushed > 0) {
                    e.flow += pushed;
                    g.get(e.to).get(e.rev).flow -= pushed; // 回退反向边
                    return pushed;
                }
            }
        }
        return 0;
    }

    public int maxFlow(int s, int t) {
        int flow = 0;
        while (true) {
            boolean[] vis = new boolean[V];
            int pushed = dfs(s, t, Integer.MAX_VALUE, vis);
            if (pushed == 0) break;
            flow += pushed;
        }
        return flow;
    }
}
