package knowledge.datastructure.graph.shortestpath;

import knowledge.datastructure.graph.ShortestPath;
import leetcode.problems.LeetCode1514_SPFA;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/29 21:40
 * 对BellmanFord优化 和 Dijkstra 很像
 * @see LeetCode1514_SPFA
 */

/*
 * Dijkstra算法和SPFA算法都是解决加权有向图中单源最短路径问题的算法，它们在实现和性能上有一些区别。
 *实现方式：Dijkstra算法使用贪心策略，每次选择当前最短路径中权重最小的节点进行扩展，直到找到目标节点或者扩展完所有节点。SPFA算法则使用了队列来优化Bellman-Ford算法，通过在队列中记录当前可能的最短路径节点，避免了对所有节点的重复松弛操作。
 *处理负权边：Dijkstra算法不能处理图中存在负权边的情况，而SPFA算法可以处理负权边。SPFA算法通过队列中节点的松弛操作来处理负权边，以此在有负权边的图中找到最短路径。
 *时间复杂度：在最坏情况下，Dijkstra算法的时间复杂度为O(V^2)，其中V是顶点的数量。而SPFA算法的平均时间复杂度为O(kE)，其中k是一个常数，E是边的数量。尽管SPFA算法在某些情况下比Dijkstra算法快，但它的最坏情况下的时间复杂度为O(VE)，而且由于队列中节点的重复出现，它可能会陷入无限循环。
 *空间复杂度：Dijkstra算法需要使用一个优先队列（或最小堆）来存储节点和其对应的最短距离，因此空间复杂度为O(V)。SPFA算法使用一个队列来存储节点，因此空间复杂度为O(V)。
 *综上所述，Dijkstra算法适用于处理没有负权边的图，而SPFA算法适用于处理有负权边的图。如果图中不存在负权边，那么Dijkstra算法通常比SPFA算法更高效。但是，如果图中存在负权边，并且负权边的数量较少，那么SPFA算法可能比Dijkstra算法更快。在实际应用中，根据具体情况选择适合的算法。
 * */

public class SPFA implements ShortestPath {

    final static int INF = 0x3f3f3f3f;

    public int[] getShortestPath(int n, int[][] edges, int s) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
        }
        // 从源节点到每个顶点的最短距离
        int[] dist = new int[n];
        // 记录节点是否在队列中
        boolean[] visited = new boolean[n];
        // 初始化所有节点的距离为无穷大
        Arrays.fill(dist, INF);
        dist[s] = 0;

        //用BFS做优化
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;

        int[] count = new int[n]; // 记录顶点进队次数

        while (!queue.isEmpty()) {
            int u = queue.poll();
            visited[u] = false;

            // 更新所有边
            for (int[] edge : graph[u]) {
                int v = edge[0];
                int w = edge[1];

                // 如果更新成功, 加入队列, 更新谁, 就那谁更新别人
                // 一个点没有更新过,再拿它更新别人一定是没有效果的
                // 只有我变小了,我后面的人才会变小
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    if (visited[v]) {
                        continue;
                    }
                    queue.add(v);
                    visited[v] = true;
                    // 记录进队次数，若超过V次，则存在负环
                    count[v]++;
                    if (count[v] >= n) {
                        return null;
                    }
                }
            }
        }
        return dist;
    }
}
