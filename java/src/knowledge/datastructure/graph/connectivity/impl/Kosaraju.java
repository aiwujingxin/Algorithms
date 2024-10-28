package knowledge.datastructure.graph.connectivity.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/3 13:54
 */
public class Kosaraju {

    public static void main(String[] args) {
        int V = 8; // 8个节点
        Graph graph = new Graph(V);

        // 添加有向边
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 3);
        graph.addEdge(6, 5);
        graph.addEdge(6, 7);
        graph.addEdge(7, 6);

        Kosaraju kosaraju = new Kosaraju(graph);
        List<List<Integer>> scc = kosaraju.findSCC();

        System.out.println("强连通分量:");
        for (List<Integer> component : scc) {
            System.out.println(component);
        }
    }

    private final Graph graph;
    private final int V;
    private final List<List<Integer>> scc;
    private final boolean[] visited;
    private final Stack<Integer> stack;

    public Kosaraju(Graph graph) {
        this.graph = graph;
        this.V = graph.getAdjacencyList().length;
        this.scc = new ArrayList<>();
        this.visited = new boolean[V];
        this.stack = new Stack<>();
    }

    public List<List<Integer>> findSCC() {
        // 第一次深度优先搜索（正向图）
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }

        // 反转图的边
        Graph reversedGraph = reverseGraph(graph);

        // 重置 visited 数组
        Arrays.fill(visited, false);

        // 第二次深度优先搜索（反向图）
        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (!visited[v]) {
                List<Integer> component = new ArrayList<>();
                dfs(reversedGraph, v, component);
                scc.add(component);
            }
        }

        return scc;
    }

    private void dfs(int v) {
        visited[v] = true;
        for (int neighbor : graph.getAdjacencyList()[v]) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
        stack.push(v);
    }

    private void dfs(Graph g, int v, List<Integer> component) {
        visited[v] = true;
        component.add(v);
        for (int neighbor : g.getAdjacencyList()[v]) {
            if (!visited[neighbor]) {
                dfs(g, neighbor, component);
            }
        }
    }

    private Graph reverseGraph(Graph g) {
        int V = g.getAdjacencyList().length;
        Graph reversedGraph = new Graph(V);

        for (int v = 0; v < V; v++) {
            for (int neighbor : g.getAdjacencyList()[v]) {
                reversedGraph.addEdge(neighbor, v);
            }
        }

        return reversedGraph;
    }

    private static class Graph {
        private final List<Integer>[] adj;

        public Graph(int V) {
            adj = new List[V];
            for (int i = 0; i < V; i++) {
                adj[i] = new ArrayList<>();
            }
        }

        public void addEdge(int u, int v) {
            adj[u].add(v);
        }

        public List<Integer>[] getAdjacencyList() {
            return adj;
        }
    }
}
