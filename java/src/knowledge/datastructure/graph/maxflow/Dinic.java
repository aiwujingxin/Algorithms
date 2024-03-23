package knowledge.datastructure.graph.maxflow;


import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/3 13:25
 */
public class Dinic {

    private final List<List<Edge>> graph;
    private final int[] level;
    private final int[] next;

    public Dinic(int V) {
        // Number of nodes in the graph
        graph = new ArrayList<>(V);
        level = new int[V];
        next = new int[V];

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v, int capacity) {
        graph.get(u).add(new Edge(v, capacity));
        // For residual graph, also add a reverse edge with capacity 0
        graph.get(v).add(new Edge(u, 0));
    }

    private boolean bfs(int source, int sink) {
        Arrays.fill(level, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        level[source] = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (Edge edge : graph.get(u)) {
                int v = edge.to;
                if (level[v] == -1 && edge.capacity - edge.flow > 0) {
                    level[v] = level[u] + 1;
                    queue.offer(v);
                }
            }
        }

        return level[sink] != -1;
    }

    private int dfs(int u, int sink, int flow) {
        if (u == sink) {
            return flow;
        }

        for (int i = next[u]; i < graph.get(u).size(); i++) {
            Edge edge = graph.get(u).get(i);
            int v = edge.to;
            if (level[v] == level[u] + 1 && edge.capacity - edge.flow > 0) {
                int pathFlow = Math.min(flow, edge.capacity - edge.flow);
                int augmentingFlow = dfs(v, sink, pathFlow);
                if (augmentingFlow > 0) {
                    edge.flow += augmentingFlow;
                    for (int j = next[u]; j < graph.get(u).size(); j++) {
                        if (graph.get(u).get(j).to == v) {
                            next[u] = j;
                            break;
                        }
                    }
                    return augmentingFlow;
                }
            }
            next[u]++;
        }

        return 0;
    }

    public int maxFlow(int source, int sink) {
        int maxFlow = 0;

        while (bfs(source, sink)) {
            Arrays.fill(next, 0);
            int pathFlow;
            while ((pathFlow = dfs(source, sink, Integer.MAX_VALUE)) > 0) {
                maxFlow += pathFlow;
            }
        }

        return maxFlow;
    }

    public static void main(String[] args) {
        int V = 6;
        Dinic dinic = new Dinic(V);

        // Add edges to the graph
        dinic.addEdge(0, 1, 16);
        dinic.addEdge(0, 2, 13);
        dinic.addEdge(1, 2, 10);
        dinic.addEdge(1, 3, 12);
        dinic.addEdge(2, 1, 4);
        dinic.addEdge(2, 4, 14);
        dinic.addEdge(3, 2, 9);
        dinic.addEdge(3, 5, 20);
        dinic.addEdge(4, 3, 7);
        dinic.addEdge(4, 5, 4);

        int source = 0;
        int sink = 5;
        int maxFlow = dinic.maxFlow(source, sink);
        System.out.println("Max Flow: " + maxFlow);
    }
}
