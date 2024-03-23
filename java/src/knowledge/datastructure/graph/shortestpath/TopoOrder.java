package knowledge.datastructure.graph.shortestpath;

import knowledge.datastructure.graph.ShortestPath;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/3 15:49
 * 算法导论 P381
 * 根据拓扑排序次序来对带权重的有向无环图进行边的松弛操作
 */
public class TopoOrder implements ShortestPath {

    public int[] getShortestPath(int n, int[][] edges, int source) {

        List<int[]>[] graph = new ArrayList[n];
        int[] topologicalOrder = new int[n];
        int[] inDegree = new int[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
            inDegree[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int u = 0; u < n; u++) {
            if (inDegree[u] == 0) {
                queue.offer(u);
            }
        }
        int orderIndex = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            topologicalOrder[orderIndex++] = u;
            for (int[] edge : graph[u]) {
                int v = edge[0];
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue.offer(v);

                }
            }
        }

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        for (int i = 0; i < n; i++) {
            int u = topologicalOrder[i];
            if (distance[u] != Integer.MAX_VALUE) {
                for (int[] edge : graph[u]) {
                    int v = edge[0];
                    int weight = edge[1];
                    distance[v] = Math.min(distance[v], distance[u] + weight);
                }
            }
        }
        return distance;
    }
}
