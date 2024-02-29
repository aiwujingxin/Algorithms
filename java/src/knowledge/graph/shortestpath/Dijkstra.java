package knowledge.graph.shortestpath;

import knowledge.graph.ShortestPath;
import leetcode.problems.LeetCode1514_Dijkstra;
import leetcode.problems.LeetCode1631;
import leetcode.problems.LeetCode1786;

import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/1 18:43
 * @see LeetCode1631
 * @see LeetCode1514_Dijkstra
 * @see LeetCode1786
 */

/*
 * Dijkstra其主要思想是贪心。
 * 将所有节点分成两类：已确定从起点到当前点的最短路长度的节点，以及未确定从起点到当前点的最短路长度的节点（下面简称「未确定节点」和「已确定节点」）。
 * 每次从「未确定节点」中取一个与起点距离最短的点，将它归类为「已确定节点」，并用它「更新」从起点到其他所有「未确定节点」的距离。直到所有点都被归类为「已确定节点」。
 */

public class Dijkstra implements ShortestPath {

    List<int[]>[] graph;

    final static int INF = Integer.MAX_VALUE / 2;

    public int[] getShortestPath(int n, int[][] edges, int source) {
        graph = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
            graph[edge[1]].add(new int[]{edge[0], edge[2]});
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
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
