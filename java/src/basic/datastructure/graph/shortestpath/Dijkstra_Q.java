package basic.datastructure.graph.shortestpath;

import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/1 18:43
 */
public class Dijkstra_Q {
    List<int[]>[] graph;
    int N;

    public int[] dijkstra(int n, int[][] edges, int source) {
        N = n + 1;
        graph = new ArrayList[N];
        for (int i = 1; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
            graph[edge[1]].add(new int[]{edge[0], edge[2]});
        }

        int[] dist = new int[N]; // 存储源节点到每个节点的最短距离
        boolean[] visited = new boolean[N]; // 记录节点是否被访问过

        Arrays.fill(dist, Integer.MAX_VALUE); // 初始化距离为无穷大
        dist[source] = 0;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        minHeap.add(new int[]{source, 0});

        while (!minHeap.isEmpty()) {
            int[] currNode = minHeap.poll();
            int currVertex = currNode[0];

            if (visited[currVertex]) {
                continue;
            }

            visited[currVertex] = true;

            for (int[] next : graph[currVertex]) {
                if (!visited[next[0]] && next[1] != 0 && dist[currVertex] != Integer.MAX_VALUE && dist[currVertex] + next[1] < dist[next[0]]) {
                    dist[next[0]] = dist[currVertex] + next[1];
                    minHeap.offer(new int[]{next[0], dist[next[0]]});
                }
            }
        }
        return dist;
    }

    public List<int[]>[] getGraph() {
        return graph;
    }

}
