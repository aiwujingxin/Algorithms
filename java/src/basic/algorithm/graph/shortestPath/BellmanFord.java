package basic.algorithm.graph.shortestPath;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/29 21:37
 * <p>
 * Bellman-Ford算法是一种用于解决加权有向图中单源最短路径问题的算法。它可以处理负权边，而Dijkstra算法则不能。
 * @see leetcode.problems.LeetCode787_BellmanFord
 * @see leetcode.problems.LeetCode1514_BellmanFord
 */

class BellmanFord {
    private final int V; // 图中顶点的数量
    private final int[] dist; // 从源节点到每个顶点的最短距离

    BellmanFord(int v) {
        V = v;
        dist = new int[V];
    }

    public static void main(String[] args) {
        int V = 5; // 图中顶点的数量
        int E = 8; // 图中边的数量

        Edge[] edges = new Edge[E];
        for (int i = 0; i < E; ++i) {
            edges[i] = new Edge();
        }

        // 设置边的起点、终点和权重
        edges[0].src = 0;
        edges[0].dest = 1;
        edges[0].weight = -1;

        edges[1].src = 0;
        edges[1].dest = 2;
        edges[1].weight = 4;

        edges[2].src = 1;
        edges[2].dest = 2;
        edges[2].weight = 3;

        edges[3].src = 1;
        edges[3].dest = 3;
        edges[3].weight = 2;

        edges[4].src = 1;
        edges[4].dest = 4;
        edges[4].weight = 2;

        edges[5].src = 3;
        edges[5].dest = 2;
        edges[5].weight = 5;

        edges[6].src = 3;
        edges[6].dest = 1;
        edges[6].weight = 1;

        edges[7].src = 4;
        edges[7].dest = 3;
        edges[7].weight = -3;

        BellmanFord algorithm = new BellmanFord(V);
        algorithm.bellmanFordAlgorithm(edges, 0);
    }

    void bellmanFordAlgorithm(Edge[] edges, int src) {
        // 初始化所有节点的距离为无穷大
        for (int i = 0; i < V; ++i) {
            dist[i] = Integer.MAX_VALUE;
        }

        // 设置源节点的距离为0
        dist[src] = 0;

        // 进行V-1次迭代更新、
        for (int i = 1; i < V; ++i) {
            for (Edge edge : edges) {
                int u = edge.src;
                int v = edge.dest;
                int weight = edge.weight;

                // 松弛操作
                // 三角不等式
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        // 检测负权回路
        for (Edge edge : edges) {
            int u = edge.src;
            int v = edge.dest;
            int weight = edge.weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("图中存在负权回路");
                return;
            }
        }

        // 输出最短路径
        System.out.println("顶点\t最短距离");
        for (int i = 0; i < V; ++i) {
            System.out.println(i + "\t\t" + dist[i]);
        }
    }

    private static class Edge {
        int src, dest, weight;

        Edge() {
            src = dest = weight = 0;
        }
    }
}