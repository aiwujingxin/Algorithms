package knowledge.datastructure.graph.mst;

import knowledge.datastructure.graph.*;

import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/3 16:24
 * @description 最小生成树 Prim 算法
 */
public class Prim implements MinimumTree {

    public int MST(int n, int[][] edges) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
            graph[edge[1]].add(new int[]{edge[0], edge[2]});
        }
        int sum = 0;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, 0x3f3f3f3f);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[1]));
        pq.offer(new int[]{0, 0});
        visited[0] = true;
        dist[0] = 0;
        while (!pq.isEmpty()) {
            int u = pq.poll()[0];
            for (int[] adj : graph[u]) {
                int v = adj[0];
                int w = adj[1];
                if (!visited[v] && w < dist[v]) {
                    dist[v] = w;
                    sum += w;
                    pq.add(new int[]{v, dist[v]});
                    if (visited[v]) {
                        continue;
                    }
                    visited[v] = true;
                }
            }
        }
        return sum;
    }
}
