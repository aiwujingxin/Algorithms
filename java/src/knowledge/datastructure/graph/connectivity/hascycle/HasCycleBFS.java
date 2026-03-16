package knowledge.datastructure.graph.connectivity.hascycle;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 3/16/26 23:51
 */
public class HasCycleBFS {

    public boolean hasCycle(int n, int[][] edges) {
        int[] inDegree = new int[n];
        List<Integer>[] graph = new ArrayList[n];
        Arrays.setAll(graph, i -> new ArrayList<>());

        // 建图并统计入度
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            inDegree[e[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) q.add(i);
        }

        int count = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            count++;
            for (int v : graph[u]) {
                if (--inDegree[v] == 0) {
                    q.add(v);
                }
            }
        }
        // 如果处理的节点数不等于总节点数，说明有环
        return count != n;
    }

}
