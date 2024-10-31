package knowledge.datastructure.graph.connectivity;

import knowledge.datastructure.graph.connectivity.directed.Kosaraju;
import knowledge.datastructure.graph.connectivity.directed.Tarjan;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 10/19/24 21:52
 * @description Tarjan与有向图连通性
 * @see Kosaraju 强连通分量
 * @see Tarjan   强连通分量
 */
public interface DirectedGraph {

    List<List<Integer>> findSCC(int n, List<Integer>[] graph);

    static void main(String[] args) {
        int V = 8;
        List<Integer>[] graph = new List[V];
        // Initialize each list in the array
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
        // Add edges to the graph
        graph[0].add(1);
        graph[1].add(2);
        graph[2].add(0);
        graph[2].add(3);
        graph[3].add(4);
        graph[4].add(5);
        graph[5].add(3);
        graph[6].add(5);
        graph[6].add(7);
        graph[7].add(6);

        List<List<Integer>> scc = new Tarjan().findSCC(V, graph);
        for (List<Integer> component : scc) {
            System.out.println("Strongly Connected Component:");
            for (int node : component) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
        System.out.println("==");
        scc = new Kosaraju().findSCC(V, graph);
        for (List<Integer> component : scc) {
            System.out.println("Strongly Connected Component:");
            for (int node : component) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }
}

