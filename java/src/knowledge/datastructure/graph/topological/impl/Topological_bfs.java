package knowledge.datastructure.graph.topological.impl;

import knowledge.datastructure.graph.topological.Topological;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/31 18:17
 */
public class Topological_bfs implements Topological {

    public int[] findOrder(int n, int[][] edges) {
        List<Integer>[] g = new List[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            g[e[1]].add(e[0]);
            d[e[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (d[i] == 0) {
                q.add(i);
            }
        }
        int[] res = new int[n];
        int cnt = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            res[cnt] = u;
            cnt++;
            for (int v : g[u]) {
                d[v]--;
                if (d[v] == 0) {
                    q.add(v);
                }
            }
        }
        if (cnt != n) {
            return new int[]{};
        }
        return res;
    }
}
