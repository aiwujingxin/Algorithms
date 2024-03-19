package knowledge.graph.shortestpath;

import knowledge.graph.*;

import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/26 18:14
 * @description 基于动态规划
 */
public class Floyd implements ShortestPath {
    final static int INF = 0x3f3f3f3f;

    public int[] getShortestPath(int n, int[][] edges, int source) {
        return floyd(n, edges)[source];
    }

    private int[][] floyd(int n, int[][] edges) {
        int[][] dist = new int[n][n];
        for (int[] d : dist) {
            Arrays.fill(d, INF);
        }
        // self
        for (int i = 0; i < dist.length; i++) {
            dist[i][i] = 0;
        }
        for (int[] edge : edges) {
            dist[edge[0]][edge[1]] = edge[2];
        }
        // 从i 只经过1-k 这些中间点, 到达 j 的最短距离
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        return dist;
    }
}
