package knowledge.datastructure.graph.connectivity.directed;

import knowledge.datastructure.graph.connectivity.DirectedGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/3 13:54
 * @description Kosaraju 强连通分量
 */
public class Kosaraju implements DirectedGraph {

    private List<Integer>[] graph;
    private int V;
    private List<List<Integer>> scc;
    private boolean[] visited;
    private Stack<Integer> stack;

    public List<List<Integer>> findSCC(int n, List<Integer>[] graph) {
        this.V = n;
        this.graph = graph;
        this.scc = new ArrayList<>();
        this.visited = new boolean[n];
        this.stack = new Stack<>();
        // 第一次深度优先搜索（正向图）
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }

        // 反转图的边
        List<Integer>[] rGraph = reverseGraph();

        // 重置 visited 数组
        Arrays.fill(visited, false);

        // 第二次深度优先搜索（反向图）
        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (!visited[v]) {
                List<Integer> component = new ArrayList<>();
                dfs(rGraph, v, component);
                scc.add(component);
            }
        }

        return scc;
    }

    private void dfs(int v) {
        visited[v] = true;
        for (int neighbor : graph[v]) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
        stack.push(v);
    }

    private void dfs(List<Integer>[] g, int v, List<Integer> component) {
        visited[v] = true;
        component.add(v);
        for (int neighbor : g[v]) {
            if (!visited[neighbor]) {
                dfs(g, neighbor, component);
            }
        }
    }

    private List<Integer>[] reverseGraph() {
        List<Integer>[] reversedGraph = new List[V];
        for (int i = 0; i < V; i++) {
            reversedGraph[i] = new ArrayList<>();
        }
        for (int v = 0; v < V; v++) {
            for (int neighbor : graph[v]) {
                reversedGraph[neighbor].add(v);
            }
        }
        return reversedGraph;
    }
}
