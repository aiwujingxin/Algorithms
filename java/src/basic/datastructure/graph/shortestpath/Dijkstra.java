package basic.datastructure.graph.shortestpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/18 14:42
 * @see leetcode.LeetCode743_Dijkstra
 * @see leetcode.LeetCode1631
 * @see leetcode.LeetCode1514_Dijkstra
 * @see leetcode.LeetCode1786
 */

/*
 * Dijkstra其主要思想是贪心。
 * 将所有节点分成两类：已确定从起点到当前点的最短路长度的节点，以及未确定从起点到当前点的最短路长度的节点（下面简称「未确定节点」和「已确定节点」）。
 * 每次从「未确定节点」中取一个与起点距离最短的点，将它归类为「已确定节点」，并用它「更新」从起点到其他所有「未确定节点」的距离。直到所有点都被归类为「已确定节点」。
 */

public class Dijkstra {

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
        for (int i = 0; i < N - 1; i++) {
            int minDistIndex = getMinDistIndex(dist, visited);
            visited[minDistIndex] = true;
            for (int[] next : graph[minDistIndex]) {
                if (!visited[next[0]] && next[1] != 0 && dist[minDistIndex] != Integer.MAX_VALUE && dist[minDistIndex] + next[1] < dist[next[0]]) {
                    dist[next[0]] = dist[minDistIndex] + next[1];
                }
            }
        }
        return dist;
    }

    private int getMinDistIndex(int[] dist, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < N; i++) {
            if (!visited[i] && dist[i] < min) {
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public List<int[]>[] getGraph() {
        return graph;
    }
}

