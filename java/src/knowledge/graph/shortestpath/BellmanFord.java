package knowledge.graph.shortestpath;

import knowledge.graph.*;
import leetcode.problems.LeetCode2093_Bellman;
import leetcode.problems.LeetCode787_BellmanFord;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/29 21:37
 * <p>
 * Bellman-Ford算法是一种用于解决加权有向图中单源最短路径问题的算法。它可以处理负权边，而Dijkstra算法则不能。
 * 可以解决带限制的最短路径
 * 差分约束系统与约束图
 * @see LeetCode2093_Bellman
 * @see LeetCode787_BellmanFord
 */

public class BellmanFord implements ShortestPath {

    final static int INF = Integer.MAX_VALUE / 2;

    public int[] getShortestPath(int n, int[][] edges, int source) {
        int[] dist = new int[n];
        // 初始化所有节点的距离为无穷大
        Arrays.fill(dist, INF);
        // 设置源节点的距离为0
        dist[source] = 0;
        // 进行V-1次迭代更新
        for (int i = 1; i < n - 1; ++i) {
            //每次松弛所有的边
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int weight = edge[2];

                // 松弛操作
                // 三角不等式
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        // 检测负权回路
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            if (dist[u] + weight < dist[v]) {
                System.out.println("图中存在负权回路");
                return null;
            }
        }
        return dist;
    }
}