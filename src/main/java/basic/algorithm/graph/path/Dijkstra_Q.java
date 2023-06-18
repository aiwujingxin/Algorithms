package basic.algorithm.graph.path;

import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/1 18:43
 */
public class Dijkstra_Q {
    private static int VERTICES; // 图的顶点数


    public void dijkstra(int[][] graph, int source) {
        int[] dist = new int[VERTICES]; // 存储源节点到每个节点的最短距离
        boolean[] visited = new boolean[VERTICES]; // 记录节点是否被访问过

        Arrays.fill(dist, Integer.MAX_VALUE); // 初始化距离为无穷大
        dist[source] = 0;

        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        minHeap.offer(new Node(source, 0));

        while (!minHeap.isEmpty()) {
            Node currNode = minHeap.poll();
            int currVertex = currNode.vertex;

            if (visited[currVertex]) {
                continue;
            }

            visited[currVertex] = true;

            for (int j = 0; j < VERTICES; j++) {
                if (!visited[j] && graph[currVertex][j] != 0 && dist[currVertex] != Integer.MAX_VALUE && dist[currVertex] + graph[currVertex][j] < dist[j]) {
                    dist[j] = dist[currVertex] + graph[currVertex][j];
                    minHeap.offer(new Node(j, dist[j]));
                }
            }
        }

        printShortestPaths(dist, source);
    }

    private void printShortestPaths(int[] dist, int source) {
        System.out.println("Vertex\t\tDistance from Source");
        for (int i = 0; i < VERTICES; i++) {
            System.out.println(i + "\t\t\t" + dist[i]);
        }
    }


    static class Node implements Comparable<Node> {
        int vertex;
        int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    public static void main(String[] args) {
        VERTICES = 6;
        int[][] graph = {
                {0, 2, 4, 0, 0, 0},
                {2, 0, 1, 4, 2, 0},
                {4, 1, 0, 0, 3, 0},
                {0, 4, 0, 0, 3, 1},
                {0, 2, 3, 3, 0, 2},
                {0, 0, 0, 1, 2, 0}};

        int source = 0;

        Dijkstra_Q dijkstra = new Dijkstra_Q();
        dijkstra.dijkstra(graph, source);
    }
}
