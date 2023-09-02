package basic.datastructure.graph.mst;

import basic.datastructure.graph.MinimumTree;
import leetcode.LeetCode1584_prim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/3 16:24
 * 和Dijkstra很像
 * @see LeetCode1584_prim
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

        int[] parent = new int[n]; // 用于存储最小生成树中每个顶点的父节点
        // 用于存储每个顶点与最小生成树的最小权值
        int[] dist = new int[n];
        boolean[] visited = new boolean[n]; // 记录顶点是否被访问过
        int res = 0;
        Arrays.fill(dist, Integer.MAX_VALUE); // 初始化所有顶点的权值为最大值

        // 将第一个顶点作为起始顶点
        dist[0] = 0;
        parent[0] = -1;

        for (int i = 0; i < n; i++) {
            int minKeyIndex = getMinKeyIndex(dist, visited);
            visited[minKeyIndex] = true;
            res += dist[minKeyIndex];
            for (int[] next : graph[minKeyIndex]) {
                if (!visited[next[0]] && next[1] < dist[next[0]]) {
                    parent[next[0]] = minKeyIndex;
                    dist[next[0]] = next[1];
                }
            }
        }
        return res;
    }

    private int getMinKeyIndex(int[] dist, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < dist.length; i++) {
            if (!visited[i] && dist[i] < min) {
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}
