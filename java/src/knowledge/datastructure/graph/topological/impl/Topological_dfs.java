package knowledge.datastructure.graph.topological.impl;

import knowledge.datastructure.graph.topological.Topological;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/31 18:19
 */
public class Topological_dfs implements Topological {

    List<Integer>[] graph;
    List<Integer> order;
    int[] c;

    public int[] findOrder(int n, int[][] edges) {
        order = new ArrayList<>();
        graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[1]].add(edge[0]);
        }
        c = new int[n];
        for (int i = 0; i < n; i++) {
            if (c[i] == 0 && dfs(i)) {
                return new int[]{};
            }
        }
        Collections.reverse(order);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = order.get(i);
        }
        return res;
    }

    private boolean dfs(int x) {
        c[x] = -1; // visiting
        for (int y : graph[x]) {
            if (c[y] == -1) {
                return true;
            }
            if (c[y] == 0  /*to_visit*/ && dfs(y)) {
                return true;
            }
        }
        c[x] = 1; // visited
        order.add(x);
        return false;
    }
}
