package basic.datastructure.graph;

import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/3 16:24
 */
public class Prim {

    static class Graph {
        private final int vertices;
        private final List<List<Edge>> adjList;

        public Graph(int vertices) {
            this.vertices = vertices;
            adjList = new ArrayList<>();

            for (int i = 0; i < vertices; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        public void addEdge(int source, int destination, int weight) {
            Edge edge1 = new Edge(destination, weight);
            Edge edge2 = new Edge(source, weight);

            adjList.get(source).add(edge1);
            adjList.get(destination).add(edge2);
        }

        public void primMST() {
            boolean[] visited = new boolean[vertices];
            int[] parent = new int[vertices];
            int[] key = new int[vertices];

            Arrays.fill(visited, false);
            Arrays.fill(key, Integer.MAX_VALUE);

            // 根节点
            key[0] = 0;
            parent[0] = -1;

            for (int i = 0; i < vertices - 1; i++) {
                int minKey = findMinKey(key, visited);
                visited[minKey] = true;

                List<Edge> edges = adjList.get(minKey);
                for (Edge edge : edges) {
                    int vertex = edge.destination;
                    int weight = edge.weight;

                    if (!visited[vertex] && weight < key[vertex]) {
                        parent[vertex] = minKey;
                        key[vertex] = weight;
                    }
                }
            }

            printMST(parent, key);
        }

        private int findMinKey(int[] key, boolean[] visited) {
            int minKey = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int i = 0; i < vertices; i++) {
                if (!visited[i] && key[i] < minKey) {
                    minKey = key[i];
                    minIndex = i;
                }
            }

            return minIndex;
        }

        private void printMST(int[] parent, int[] key) {
            System.out.println("Edge \tWeight");
            for (int i = 1; i < vertices; i++) {
                System.out.println(parent[i] + " - " + i + "\t" + key[i]);
            }
        }

        static class Edge {
            int destination;
            int weight;

            public Edge(int destination, int weight) {
                this.destination = destination;
                this.weight = weight;
            }
        }
    }

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
        graph.primMST();
    }
}
