package basic.datastructure.graph.shortestpath;

import basic.datastructure.graph.ShortestPath;

import java.util.Arrays;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/26 18:14
 * 基于动态规划
 */
public class Floyd implements ShortestPath {
    final static int INF = 99999;

    public static void main(String[] args) {
        /* Let us create the following weighted graph
             10
        (0)------->(3)
        |         /|\
      5 |          | 1
        |          |
        \|/         |
        (1)------->(2)
              3           */
        Floyd a = new Floyd();
        // Print the solution
        int n = 4;
        int[][] dist = a.floyd(n, new int[][]{{0, 3, 10}, {0, 1, 5}, {1, 2, 3}, {2, 3, 1}});
        System.out.println("The following matrix shows the shortest distances between every pair of vertices");
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + "   ");
                }
            }
            System.out.println();
        }
    }

    public int[] getShortestPath(int n, int[][] edges, int source) {
        return floyd(n, edges)[source];
    }

    private int[][] floyd(int n, int[][] edges) {
        int[][] dist = new int[n][n];
        for (int[] d : dist) {
            Arrays.fill(d, INF);
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
