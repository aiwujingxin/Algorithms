package knowledge.datastructure.graph.detectcycle;

import java.util.ArrayList;
import java.util.List;

public class FundamentalCycle {

    public static void main(String[] args) {
        int V = 7; // 图的节点数
        Graph graph = new Graph(V);

        // 添加图的边
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 0);
        graph.addEdge(2, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 3);

        FundamentalCycle fct = new FundamentalCycle(graph);
        fct.findFundamentalCycleTree();
    }

    private final Graph graph;
    private final int V;
    private final boolean[] visited;
    private final int[] parent;
    private final int[] depth;

    public FundamentalCycle(Graph graph) {
        this.graph = graph;
        this.V = graph.getAdjacencyList().size();
        this.visited = new boolean[V];
        this.parent = new int[V];
        this.depth = new int[V];
    }

    public void findFundamentalCycleTree() {
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, -1, 0);
            }
        }
    }

    private void dfs(int u, int par, int d) {
        visited[u] = true;
        parent[u] = par;
        depth[u] = d;
        for (int v : graph.getAdjacencyList().get(u)) {
            if (!visited[v]) {
                dfs(v, u, d + 1);
            } else if (v != par && depth[v] < depth[u]) {
                // 找到一个基环
                List<Integer> cycle = new ArrayList<>();
                int cur = u;
                while (cur != v) {
                    cycle.add(cur);
                    cur = parent[cur];
                }
                cycle.add(v);

                // 处理基环，这里可以根据需求进行操作
                System.out.println("Found a fundamental cycle:");
                for (int node : cycle) {
                    System.out.print(node + " ");
                }
                System.out.println();
            }
        }
    }


    static class Graph {
        private int V; // 图的节点数
        private List<List<Integer>> adj; // 邻接表

        public Graph(int V) {
            this.V = V;
            adj = new ArrayList<>(V);
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
        }

        public void addEdge(int u, int v) {
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        public List<List<Integer>> getAdjacencyList() {
            return adj;
        }
    }
}
