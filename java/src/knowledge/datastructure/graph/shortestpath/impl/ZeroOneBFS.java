package knowledge.datastructure.graph.shortestpath.impl;

import knowledge.datastructure.graph.shortestpath.ShortestPath;

import java.util.*;

import leetcode.problems.*;

/**
 * @author wujingxinit@outlook.com
 * @date 9/11/25 16:07
 * @description 0-1 BFS 在边权仅为 0 或 1 的非负权图上，用双端队列模拟 Dijkstra 的松弛过程，实现按“代价非降序”推进的最短路搜索。
 * @see LeetCode3286
 */
public class ZeroOneBFS implements ShortestPath {

    static final int INF = 0x3f3f3f3f;

    // 无向图 0-1 BFS，若为有向图删除反向边。边权必须为 0 或 1。
    public int[] shortestPath(int n, int[][] edges, int s) {
        List<int[]>[] g = new List[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            g[u].add(new int[]{v, w});
            g[v].add(new int[]{u, w}); // 有向图请删除
        }
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        Deque<Integer> dq = new ArrayDeque<>();
        dist[s] = 0;
        dq.addFirst(s);
        while (!dq.isEmpty()) {
            int u = dq.pollFirst();
            int du = dist[u];
            if (du == INF) continue; // 保险
            for (int[] edge : g[u]) {
                int v = edge[0], w = edge[1]; // w ∈ {0,1}
                int nd = du + w;
                if (nd < dist[v]) {
                    dist[v] = nd;
                    if (w == 0) dq.addFirst(v);
                    else dq.addLast(v);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dist[i] >= INF) dist[i] = -1;
        }
        return dist;
    }
}
