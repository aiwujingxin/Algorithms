package leetcode.problems;


import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 8/26/25 16:48
 */
public class LeetCode2492_dij {

    final static int INF = 0x3f3f3f3f;

    int min = Integer.MAX_VALUE;

    public int minScore(int n, int[][] roads) {
        shortestPath(n, roads, 1);
        return min;
    }

    public int[] shortestPath(int n, int[][] edges, int s) {
        List<int[]>[] graph = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            graph[e[1]].add(new int[]{e[0], e[2]});
        }
        int[] d = new int[n + 1];
        Arrays.fill(d, INF);
        d[s] = 0;
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.add(new int[]{s, 0});
        while (!pq.isEmpty()) {
            int u = pq.poll()[0];
            for (int[] edge : graph[u]) {
                int v = edge[0];
                int w = edge[1];
                if (d[v] > w) {
                    d[v] = w;
                    min = Math.min(min, d[v]);
                    pq.add(new int[]{v, d[v]});
                }
            }
        }
        return d;
    }
}
