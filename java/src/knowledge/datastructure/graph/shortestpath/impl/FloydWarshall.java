package knowledge.datastructure.graph.shortestpath.impl;

import knowledge.datastructure.graph.shortestpath.ShortestPath;

import java.util.Arrays;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/26 18:14
 * @description Floyd 基于动态规划
 * 时间复杂度: O(V^3)
 */
public class FloydWarshall implements ShortestPath {
    final static int INF = 0x3f3f3f3f;

    public int[] shortestPath(int n, int[][] edges, int s) {
        return floyd(n, edges)[s];
    }

    private int[][] floyd(int n, int[][] edges) {
        int[][] dist = new int[n][n];
        for (int[] d : dist) Arrays.fill(d, INF);
        for (int i = 0; i < n; i++) dist[i][i] = 0;
        for (int[] edge : edges) {
            dist[edge[0]][edge[1]] = edge[2];
        }
        // 从i 只经过1-k 这些中间点, 到达 j 的最短距离
        for (int k = 0; k < n; k++) { // 枚举每个跳板
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        return dist;
    }
}
