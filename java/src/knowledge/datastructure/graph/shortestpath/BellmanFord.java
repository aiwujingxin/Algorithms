package knowledge.datastructure.graph.shortestpath;

import knowledge.datastructure.graph.ShortestPath;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/29 21:37
 * @description Bellman-Ford 算法是一种用于解决加权有向图中单源最短路径问题的算法。
 * 它可以处理负权边，而Dijkstra算法则不能。
 * 可以解决带限制的最短路径
 * 差分约束系统与约束图
 */
public class BellmanFord implements ShortestPath {

    final static int INF = 0x3f3f3f3f;

    public int[] getShortestPath(int n, int[][] edges, int s) {
        int[] d = new int[n];
        Arrays.fill(d, INF);
        d[s] = 0;
        for (int i = 1; i < n - 1; ++i) { // 进行V-1次迭代更新
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                if (d[v] > d[u] + w) {
                    d[v] = d[u] + w;
                }
            }
        }
        // 检测负权回路
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            if (d[u] + weight < d[v]) {
                System.out.println("图中存在负权回路");
                return null;
            }
        }
        return d;
    }
}