package basic.algorithm.graph.bipartite;


import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/19 23:23
 */

class BipartiteGraph_bfs {

    public static void main(String[] args) {
        int vertices = 4;
        BipartiteGraph_bfs graph = new BipartiteGraph_bfs(vertices);

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

    private final int vertices;
    private final int[][] adjacencyMatrix;

    public BipartiteGraph_bfs(int vertices) {
        this.vertices = vertices;
        adjacencyMatrix = new int[vertices][vertices];
    }

    public void addEdge(int source, int destination) {
        adjacencyMatrix[source][destination] = 1;
        adjacencyMatrix[destination][source] = 1;
    }

    public boolean isBipartite() {
        int[] colors = new int[vertices];
        Arrays.fill(colors, -1);
        for (int i = 0; i < vertices; i++) {
            if (colors[i] == -1) {
                if (!bfs(i, colors)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean bfs(int source, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        colors[source] = 0;
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            if (adjacencyMatrix[currentVertex][currentVertex] == 1) {
                return false; // Self-loop, not a bipartite graph
            }
            for (int i = 0; i < vertices; i++) {
                if (adjacencyMatrix[currentVertex][i] == 1 && colors[i] == -1) {
                    colors[i] = 1 - colors[currentVertex];
                    queue.add(i);
                } else if (adjacencyMatrix[currentVertex][i] == 1 && colors[i] == colors[currentVertex]) {
                    return false; // Adjacent vertices with the same color, not a bipartite graph
                }
            }
        }
        return true;
    }
}
