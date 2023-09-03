package basic.datastructure.graph.connectivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/3 13:45
 * 查找有向图的强连通分量
 */
public class TarjanSCC {


    public static void main(String[] args) {
        int V = 8;
        TarjanSCC tarjan = new TarjanSCC(V);
        // 添加有向边
        tarjan.addEdge(0, 1);
        tarjan.addEdge(1, 2);
        tarjan.addEdge(2, 0);
        tarjan.addEdge(2, 3);
        tarjan.addEdge(3, 4);
        tarjan.addEdge(4, 5);
        tarjan.addEdge(5, 3);
        tarjan.addEdge(6, 5);
        tarjan.addEdge(6, 7);
        tarjan.addEdge(7, 6);
        List<List<Integer>> scc = tarjan.findSCC();
        for (List<Integer> component : scc) {
            System.out.println("Strongly Connected Component:");
            for (int node : component) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }

    private final int V; // 图的节点数
    private final List<List<Integer>> graph;
    private final int[] ids;
    private final int[] low;
    private final boolean[] onStack;
    private final Stack<Integer> stack;
    private final List<List<Integer>> scc; // 强连通分量

    private int id;

    public TarjanSCC(int V) {
        this.V = V;
        graph = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        ids = new int[V];
        low = new int[V];
        onStack = new boolean[V];
        stack = new Stack<>();
        scc = new ArrayList<>();
    }

    public void addEdge(int u, int v) {
        graph.get(u).add(v);
    }

    public List<List<Integer>> findSCC() {
        for (int i = 0; i < V; i++) {
            if (ids[i] == 0) {
                dfs(i);
            }
        }
        return scc;
    }

    private void dfs(int at) {
        stack.push(at);
        onStack[at] = true;
        ids[at] = low[at] = ++id;

        for (int to : graph.get(at)) {
            if (ids[to] == 0) {
                dfs(to);
            }
            if (onStack[to]) {
                low[at] = Math.min(low[at], low[to]);
            }
        }

        if (ids[at] == low[at]) {
            List<Integer> component = new ArrayList<>();
            while (true) {
                int node = stack.pop();
                onStack[node] = false;
                component.add(node);
                if (node == at) {
                    break;
                }
            }
            scc.add(component);
        }
    }

}
