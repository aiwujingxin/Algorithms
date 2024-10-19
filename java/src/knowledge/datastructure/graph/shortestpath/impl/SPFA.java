package knowledge.datastructure.graph.shortestpath.impl;

import knowledge.datastructure.graph.shortestpath.ShortestPath;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/29 21:40
 * @description SPFA 对Bellman-Ford 队列优化
 * 时间复杂度 O(E), 最坏情况下 O(V*E)
 * 空间复杂度为O(V)。
 */
public class SPFA implements ShortestPath {

    final static int INF = 0x3f3f3f3f;

    public int[] shortestPath(int n, int[][] edges, int s) {
        List<int[]>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
        }
        int[] cnt = new int[n]; // 记录点进队次数. 判断负环
        int[] d = new int[n];
        boolean[] vis = new boolean[n];
        Arrays.fill(d, INF);
        d[s] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        vis[s] = true;
        while (!q.isEmpty()) {
            int u = q.poll();
            vis[u] = false;
            for (int[] ne : graph[u]) {
                int v = ne[0];
                int w = ne[1];
                if (d[v] > d[u] + w) {
                    d[v] = d[u] + w;
                    if (!vis[v]) {
                        q.add(v); // 只考察有必要的点
                        vis[v] = true;
                        cnt[v]++;
                        if (cnt[v] >= n) {
                            System.out.println("图中存在负权回路");
                            return null;
                        }
                    }
                }
            }
        }
        return d;
    }
}
