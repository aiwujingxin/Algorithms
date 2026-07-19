package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 5/6/26 20:18
 */
public class LeetCode3112 {

    public List<int[]>[] graph;
    final static int INF = 0x3f3f3f3f;

    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        this.graph = new List[n];
        Arrays.setAll(graph, i -> new ArrayList<>());
        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            graph[e[1]].add(new int[]{e[0], e[2]});
        }
        int s = 0;
        int[] d = new int[n];
        Arrays.fill(d, INF);
        d[s] = 0;
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.add(new int[]{s, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], dist = cur[1];
            if (dist > d[u]) continue;
            if (dist > disappear[u]) continue;
            for (int[] edge : graph[u]) {
                int v = edge[0];
                int w = edge[1];
                if (d[v] > d[u] + w && d[v] < disappear[v]) {
                    d[v] = d[u] + w;
                    pq.add(new int[]{v, d[v]});
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (d[i] == INF) d[i] = -1;
        }
        return d;
    }
}
