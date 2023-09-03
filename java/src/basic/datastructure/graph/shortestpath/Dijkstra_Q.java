package basic.datastructure.graph.shortestpath;

import basic.datastructure.graph.ShortestPath;

import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/1 18:43
 */
public class Dijkstra_Q implements ShortestPath {

    List<int[]>[] graph;

    public int[] getShortestPath(int n, int[][] edges, int source) {
        graph = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
            graph[edge[1]].add(new int[]{edge[0], edge[2]});
        }
        int[] dist = new int[n + 1]; // 存储源节点到每个节点的最短距离
        Arrays.fill(dist, Integer.MAX_VALUE); // 初始化距离为无穷大
        dist[source] = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        minHeap.add(new int[]{source, 0});
        while (!minHeap.isEmpty()) {
            int[] currNode = minHeap.poll();
            int currVertex = currNode[0];
            for (int[] next : graph[currVertex]) {
                int distToNextNode = dist[currVertex] + next[1];
                if (distToNextNode < dist[next[0]]) {
                    dist[next[0]] = distToNextNode;
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
