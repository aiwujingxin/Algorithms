package knowledge.datastructure.graph.shortestpath.impl;

import knowledge.datastructure.graph.shortestpath.ShortestPath;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/3 15:49
 * @description 拓扑排序求最短路. 根据拓扑排序次序来对带权重的有向无环图进行边的松弛操作.
 * @link 算法导论 P381
 */
public class TopoOrder implements ShortestPath {

    public int[] shortestPath(int n, int[][] edges, int s) {
        List<int[]>[] graph = new List[n];
        int[] topo = new int[n];
        int[] in = new int[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
            in[edge[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int u = 0; u < n; u++) {
            if (in[u] == 0) {
                q.add(u);
            }
        }
        int index = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            topo[index++] = u;
            for (int[] edge : graph[u]) {
                int v = edge[0];
                in[v]--;
                if (in[v] == 0) {
                    q.add(v);
                }
            }
        }
        int[] d = new int[n];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[0] = 0;
        for (int i = 0; i < n; i++) {
            int u = topo[i];
            if (d[u] != Integer.MAX_VALUE) {
                for (int[] ne : graph[u]) {
                    int v = ne[0];
                    int w = ne[1];
                    d[v] = Math.min(d[v], d[u] + w);
                }
            }
        }
        return d;
    }
}
