package knowledge.graph.maxflow;


import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/3 13:24
 */

public class EdmondsKarp {
    private final int V; // Number of nodes in the graph
    private final List<List<Edge>> graph;

    public EdmondsKarp(int V) {
        this.V = V;
        graph = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v, int capacity) {
        graph.get(u).add(new Edge(v, capacity));
        // For residual graph, also add a reverse edge with capacity 0
        graph.get(v).add(new Edge(u, 0));
    }

    private boolean bfs(int source, int sink, int[] parent) {
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        visited[source] = true;
        parent[source] = -1;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (Edge edge : graph.get(u)) {
                int v = edge.to;
                if (!visited[v] && edge.capacity - edge.flow > 0) {
                    queue.offer(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }

        return visited[sink];
    }

    public int maxFlow(int source, int sink) {
        int[] parent = new int[V];
        int maxFlow = 0;

        while (bfs(source, sink, parent)) {
            int pathFlow = Integer.MAX_VALUE;
            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                for (Edge edge : graph.get(u)) {
                    if (edge.to == v) {
                        pathFlow = Math.min(pathFlow, edge.capacity - edge.flow);
                        break;
                    }
                }
            }

            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                for (Edge edge : graph.get(u)) {
                    if (edge.to == v) {
                        edge.flow += pathFlow;
                        break;
                    }
                }
            }

            maxFlow += pathFlow;
        }

        return maxFlow;
    }


    public static void main(String[] args) {
        int V = 6;
        EdmondsKarp edmondsKarp = new EdmondsKarp(V);

        // Add edges to the graph
        edmondsKarp.addEdge(0, 1, 16);
        edmondsKarp.addEdge(0, 2, 13);
        edmondsKarp.addEdge(1, 2, 10);
        edmondsKarp.addEdge(1, 3, 12);
        edmondsKarp.addEdge(2, 1, 4);
        edmondsKarp.addEdge(2, 4, 14);
        edmondsKarp.addEdge(3, 2, 9);
        edmondsKarp.addEdge(3, 5, 20);
        edmondsKarp.addEdge(4, 3, 7);
        edmondsKarp.addEdge(4, 5, 4);

        int source = 0;
        int sink = 5;
        int maxFlow = edmondsKarp.maxFlow(source, sink);
        System.out.println("Max Flow: " + maxFlow);
    }
}