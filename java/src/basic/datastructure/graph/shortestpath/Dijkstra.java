package basic.datastructure.graph.shortestpath;

import java.util.Arrays;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/18 14:42
 */
public class Dijkstra {

    /*
     * Dijkstra其主要思想是贪心。
     * 将所有节点分成两类：已确定从起点到当前点的最短路长度的节点，以及未确定从起点到当前点的最短路长度的节点（下面简称「未确定节点」和「已确定节点」）。
     * 每次从「未确定节点」中取一个与起点距离最短的点，将它归类为「已确定节点」，并用它「更新」从起点到其他所有「未确定节点」的距离。直到所有点都被归类为「已确定节点」。
     */

    private static final int VERTICES = 6; // 图的顶点数

    public static void main(String[] args) {
        int[][] graph = {
                {0, 2, 4, 0, 0, 0},
                {2, 0, 1, 4, 2, 0},
                {4, 1, 0, 0, 3, 0},
                {0, 4, 0, 0, 3, 1},
                {0, 2, 3, 3, 0, 2},
                {0, 0, 0, 1, 2, 0}
        };
        int source = 0;
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.dijkstra(graph, source);
    }

    public void dijkstra(int[][] graph, int source) {
        int[] dist = new int[VERTICES]; // 存储源节点到每个节点的最短距离
        boolean[] visited = new boolean[VERTICES]; // 记录节点是否被访问过

        Arrays.fill(dist, Integer.MAX_VALUE); // 初始化距离为无穷大
        dist[source] = 0;

        for (int i = 0; i < VERTICES - 1; i++) {
            int minDistIndex = getMinDistIndex(dist, visited);
            visited[minDistIndex] = true;

            for (int j = 0; j < VERTICES; j++) {
                if (!visited[j] && graph[minDistIndex][j] != 0 && dist[minDistIndex] != Integer.MAX_VALUE &&
                        dist[minDistIndex] + graph[minDistIndex][j] < dist[j]) {
                    dist[j] = dist[minDistIndex] + graph[minDistIndex][j];
                }
            }
        }

        printShortestPaths(dist, source);
    }

    private int getMinDistIndex(int[] dist, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < VERTICES; i++) {
            if (!visited[i] && dist[i] < min) {
                min = dist[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    private void printShortestPaths(int[] dist, int source) {
        System.out.println("Vertex\t\tDistance from Source");
        for (int i = 0; i < VERTICES; i++) {
            System.out.println(i + "\t\t\t" + dist[i]);
        }
    }
}
