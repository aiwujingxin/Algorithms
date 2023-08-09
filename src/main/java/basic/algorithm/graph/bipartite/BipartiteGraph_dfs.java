package basic.algorithm.graph.bipartite;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/19 23:31
 */
public class BipartiteGraph_dfs {

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        if (graph.isBipartite()) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }
    }

    static class Graph {
        private final int V;
        private final List<Integer>[] adjList;

        public Graph(int V) {
            this.V = V;
            adjList = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                adjList[i] = new ArrayList<>();
            }
        }

        public void addEdge(int v, int w) {
            adjList[v].add(w);
            adjList[w].add(v);
        }

        public boolean isBipartite() {
            int[] colors = new int[V];
            for (int i = 0; i < V; i++) {
                colors[i] = -1;
            }
            for (int i = 0; i < V; i++) {
                if (colors[i] == -1) {
                    if (!dfs(i, colors, 0)) {
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean dfs(int v, int[] colors, int color) {
            colors[v] = color;
            for (int neighbor : adjList[v]) {
                if (colors[neighbor] == color) {
                    return false;
                }
                if (colors[neighbor] == -1 && !dfs(neighbor, colors, 1 - color)) {
                    return false;
                }
            }
            return true;
        }
    }
}
