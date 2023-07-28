package basic.algorithm.graph.path;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/26 18:14
 * 基于动态规划
 */
public class Floyd {
    final static int INF = 99999, V = 4;

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
        int[][] graph = {{0, 5, INF, 10}, {INF, 0, 3, INF}, {INF, INF, 0, 1}, {INF, INF, INF, 0}};
        Floyd a = new Floyd();
        // Print the solution
        a.floyd(graph);
    }

    private void floyd(int[][] graph) {
        int[][] dist = new int[V][V];
        int i, j, k;
        for (i = 0; i < V; i++) {
            for (j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }
        // 从i 只经过1-k 这些中间点, 到达 j 的最短距离
        for (k = 0; k < V; k++) {
            for (i = 0; i < V; i++) {
                for (j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        printSolution(dist);
    }

    void printSolution(int[][] dist) {
        System.out.println("The following matrix shows the shortest distances between every pair of vertices");
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + "   ");
                }
            }
            System.out.println();
        }
    }
}
