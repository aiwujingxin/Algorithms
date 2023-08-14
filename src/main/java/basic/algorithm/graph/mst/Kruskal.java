package basic.algorithm.graph.mst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/3 16:24
 */
public class Kruskal {

    public static void main(String[] args) {
        int vertices = 5;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 6);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 8);
        graph.addEdge(1, 4, 5);
        graph.addEdge(2, 4, 7);
        graph.addEdge(3, 4, 9);
        graph.kruskalMST();
    }

    static class Graph {
        private final int vertices;
        private final List<Edge> edges;

        public Graph(int vertices) {
            this.vertices = vertices;
            edges = new ArrayList<>();
        }

        public void addEdge(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            edges.add(edge);
        }

        public void kruskalMST() {
            // 将边按权重从小到大排序
            Collections.sort(edges);

            // 使用并查集存储顶点的连通分量
            int[] parent = new int[vertices];
            for (int i = 0; i < vertices; i++) {
                parent[i] = i;
            }

            List<Edge> mst = new ArrayList<>();

            for (Edge edge : edges) {
                int sourceParent = find(parent, edge.source);
                int destinationParent = find(parent, edge.destination);

                // 判断加入边是否形成环路
                if (sourceParent != destinationParent) {
                    mst.add(edge);
                    parent[sourceParent] = destinationParent;
                }
            }

            // 打印最小生成树
            System.out.println("Edge \tWeight");
            for (Edge edge : mst) {
                System.out.println(edge.source + " - " + edge.destination + "\t" + edge.weight);
            }
        }

        private int find(int[] parent, int vertex) {
            if (parent[vertex] != vertex) {
                parent[vertex] = find(parent, parent[vertex]);
            }
            return parent[vertex];
        }
    }

    static class Edge implements Comparable<Edge> {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }
}
