package knowledge.datastructure.graph.shortestpath.impl;

import knowledge.datastructure.graph.shortestpath.ShortestPath;

import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/1 18:43
 * @description Dijkstra 其主要思想是贪心。
 * 原理: 将所有节点分成两类：已确定从起点到当前点的最短路长度的节点，以及未确定从起点到当前点的最短路长度的节点（下面简称「未确定节点」和「已确定节点」）。
 * 每次从「未确定节点」中取一个与起点距离最短的点，将它归类为「已确定节点」，并用它「更新」从起点到其他所有「未确定节点」的距离。直到所有点都被归类为「已确定节点」。
 * 时间复杂度: 朴素版:O(V^2), 堆优化版 O(ElogV)
 */

public class Dijkstra implements ShortestPath {

    public List<int[]>[] graph;
    final static int INF = 0x3f3f3f3f;

    public int[] shortestPath(int n, int[][] edges, int s) {
        this.graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            graph[e[1]].add(new int[]{e[0], e[2]});
        }
        int[] d = new int[n];
        Arrays.fill(d, INF);
        d[s] = 0;
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.add(new int[]{s, 0});
        while (!pq.isEmpty()) {
            int u = pq.poll()[0];
            for (int[] edge : graph[u]) {
                int v = edge[0];
                int w = edge[1];
                if (d[v] > d[u] + w) {
                    d[v] = d[u] + w;
                    pq.add(new int[]{v, d[v]});
                }
            }
        }
        return d;
    }
}
