package knowledge.datastructure.graph.shortestpath;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/10/19 21:37
 * @description johnson算法
 * 时间复杂度主要由两个部分组成：Bellman-Ford算法和Dijkstra算法。
 * O(V*E + V^2 * log V)
 */

public class Johnson {
    // 图的邻接表
    public List<int[]>[] graph;
    private final int V; // 顶点数量

    public Johnson(List<int[]>[] graph) {
        this.graph = graph;
        this.V = graph.length;
    }

    // 主函数：执行Johnson算法
    public int[][] johnson() {
        // Step 1: 构建一个新的图，并添加一个虚拟的源节点s。
        int[] h = new int[V + 1];
        if (!bellmanFord(h)) {
            throw new IllegalArgumentException("图中存在负权回路");
        }

        // Step 2: 使用Bellman-Ford的结果重新调整图的权重
        List<int[]>[] reweightedGraph = reweighGraph(h);

        // Step 3: 运行Dijkstra算法，求出每对节点之间的最短路径
        int[][] dist = new int[V][V];
        for (int u = 0; u < V; u++) {
            dist[u] = dijkstra(u, reweightedGraph, h);
        }

        return dist;
    }

    // Bellman-Ford算法
    private boolean bellmanFord(int[] h) {
        Arrays.fill(h, Integer.MAX_VALUE);
        h[V] = 0; // 新增的虚拟源节点s，h[s] = 0

        // 扩展图，加上虚拟的源节点s，连接到所有其他节点
        List<int[]>[] extendedGraph = new List[V + 1];
        for (int i = 0; i <= V; i++) {
            extendedGraph[i] = new ArrayList<>();
        }
        for (int i = 0; i < V; i++) {
            extendedGraph[V].add(new int[]{i, 0}); // 从虚拟节点V到其他节点的权重为0
            for (int[] edge : graph[i]) {
                extendedGraph[i].add(edge);
            }
        }

        // Relax all edges |V| times
        h[V] = 0; // 虚拟节点
        for (int i = 0; i <= V; i++) {
            boolean updated = false;
            for (int u = 0; u <= V; u++) {
                if (h[u] == Integer.MAX_VALUE) continue;
                for (int[] edge : extendedGraph[u]) {
                    int v = edge[0], weight = edge[1];
                    if (h[v] > h[u] + weight) {
                        h[v] = h[u] + weight;
                        updated = true;
                    }
                }
            }
            // 如果没有更新，提前退出
            if (!updated) break;
        }

        // 检查是否存在负权回路
        for (int u = 0; u <= V; u++) {
            for (int[] edge : extendedGraph[u]) {
                int v = edge[0], weight = edge[1];
                if (h[u] != Integer.MAX_VALUE && h[v] > h[u] + weight) {
                    return false; // 发现负权回路
                }
            }
        }

        return true;
    }

    // 重新调整图的权重
    private List<int[]>[] reweighGraph(int[] h) {
        List<int[]>[] reweighedGraph = new List[V];
        for (int u = 0; u < V; u++) {
            reweighedGraph[u] = new ArrayList<>();
            for (int[] edge : graph[u]) {
                int v = edge[0], weight = edge[1];
                int newWeight = weight + h[u] - h[v];
                reweighedGraph[u].add(new int[]{v, newWeight});
            }
        }
        return reweighedGraph;
    }

    // Dijkstra算法求单源最短路径
    private int[] dijkstra(int src, List<int[]>[] reweightedGraph, int[] h) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        pq.offer(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0], d = current[1];
            if (d > dist[u]) continue;

            for (int[] edge : reweightedGraph[u]) {
                int v = edge[0], weight = edge[1];
                if (dist[v] > dist[u] + weight) {
                    dist[v] = dist[u] + weight;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }

        // 转换回原来的权重
        for (int v = 0; v < V; v++) {
            if (dist[v] < Integer.MAX_VALUE) {
                dist[v] = dist[v] + h[v] - h[src];
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        // 创建图（例如有5个节点）
        int V = 5;
        List<int[]>[] graph = new List[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // 添加边 (u, v, weight)
        graph[0].add(new int[]{1, 3});
        graph[0].add(new int[]{2, 8});
        graph[1].add(new int[]{2, -2});
        graph[1].add(new int[]{3, 1});
        graph[2].add(new int[]{4, 2});
        graph[3].add(new int[]{4, 4});

        // 执行Johnson算法
        Johnson johnson = new Johnson(graph);
        try {
            int[][] distances = johnson.johnson();
            for (int i = 0; i < V; i++) {
                System.out.println("From node " + i + ": " + Arrays.toString(distances[i]));
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}