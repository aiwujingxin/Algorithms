package knowledge.datastructure.graph.networkflow.impl;


import knowledge.datastructure.graph.networkflow.MaxFlow;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/3 13:24
 */

public class EdmondsKarp implements MaxFlow {
    private int V;
    List<List<Edge>> g;

    public EdmondsKarp() {
    }

    public EdmondsKarp(int V) {
        this.V = V;
        g = new ArrayList<>(V);
        for (int i = 0; i < V; i++) g.add(new ArrayList<>());
    }

    @Override
    public int maxFlow(int n, int[][] edges) {
        int S = 2 * n, T = 2 * n + 1, V = 2 * n + 2;
        EdmondsKarp ff = new EdmondsKarp(V);
        for (int u = 0; u < n; u++) ff.addEdge(S, u, 1);
        for (int[] e : edges) ff.addEdge(e[0], n + e[1], 1);
        for (int v = 0; v < n; v++) ff.addEdge(n + v, T, 1);
        return ff.maxFlow(S, T);
    }

    public void addEdge(int u, int v, int cap) {
        Edge a = new Edge(v, g.get(v).size(), cap);
        Edge b = new Edge(u, g.get(u).size(), 0);
        g.get(u).add(a);
        g.get(v).add(b);
    }

    // 记录到达每个点所用的边引用 (prevEdge[v]) 与前驱点 (prevNode[v])
    private boolean bfs(int s, int t, int[] prevNode, Edge[] prevEdge) {
        Arrays.fill(prevNode, -1);
        Arrays.fill(prevEdge, null);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(s);
        prevNode[s] = s;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (Edge e : g.get(u)) {
                if (prevNode[e.to] == -1 && e.residual() > 0) {
                    prevNode[e.to] = u;
                    prevEdge[e.to] = e;
                    if (e.to == t) return true;
                    q.add(e.to);
                }
            }
        }
        return false;
    }

    public int maxFlow(int s, int t) {
        int flow = 0;
        int[] prevNode = new int[V];
        Edge[] prevEdge = new Edge[V];
        while (bfs(s, t, prevNode, prevEdge)) {
            int add = Integer.MAX_VALUE;
            // 1) 找瓶颈
            for (int v = t; v != s; v = prevNode[v]) {
                add = Math.min(add, prevEdge[v].residual());
            }
            // 2) 沿路径增广：正向 +add，反向 -add
            for (int v = t; v != s; v = prevNode[v]) {
                Edge e = prevEdge[v];
                e.flow += add;
                g.get(e.to).get(e.rev).flow -= add; // 回退反向边
            }
            flow += add;
        }
        return flow;
    }
}