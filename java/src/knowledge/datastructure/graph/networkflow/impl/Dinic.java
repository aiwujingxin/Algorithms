package knowledge.datastructure.graph.networkflow.impl;


import knowledge.datastructure.graph.networkflow.MaxFlow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/3 13:25
 */

public class Dinic implements MaxFlow {

    public List<List<Edge>> g;
    private int[] level;
    private int[] it;

    public Dinic() {
    }

    public Dinic(int n) {
        g = new ArrayList<>(n);
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        level = new int[n];
        it = new int[n];
    }

    @Override
    public int maxFlow(int n, int[][] edges) {
        int S = 2 * n, T = 2 * n + 1, V = 2 * n + 2;
        Dinic ff = new Dinic(V);
        for (int u = 0; u < n; u++) ff.addEdge(S, u, 1);
        for (int[] e : edges) ff.addEdge(e[0], n + e[1], 1);
        for (int v = 0; v < n; v++) ff.addEdge(n + v, T, 1);
        return ff.maxFlow(S, T);
    }

    // 加双向：正向(cap)，反向(0)；互存 rev 索引
    public void addEdge(int u, int v, int cap) {
        Edge a = new Edge(v, g.get(v).size(), cap);
        Edge b = new Edge(u, g.get(u).size(), 0);
        g.get(u).add(a);
        g.get(v).add(b);
    }

    private boolean bfs(int s, int t) {
        Arrays.fill(level, -1);
        ArrayDeque<Integer> q = new ArrayDeque<>();
        level[s] = 0;
        q.add(s);
        while (!q.isEmpty()) {
            int u = q.poll();
            for (Edge e : g.get(u)) {
                if (e.residual() > 0 && level[e.to] == -1) {
                    level[e.to] = level[u] + 1;
                    q.add(e.to);
                }
            }
        }
        return level[t] != -1;
    }

    private int dfs(int u, int t, int f) {
        if (u == t) return f;
        for (; it[u] < g.get(u).size(); it[u]++) {
            Edge e = g.get(u).get(it[u]);
            if (e.residual() > 0 && level[e.to] == level[u] + 1) {
                int pushed = dfs(e.to, t, Math.min(f, e.residual()));
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
        while (bfs(s, t)) {
            Arrays.fill(it, 0);
            int pushed;
            while ((pushed = dfs(s, t, Integer.MAX_VALUE)) > 0) {
                flow += pushed;
            }
        }
        return flow;
    }
}
