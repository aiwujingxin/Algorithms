package knowledge.datastructure.graph.connectivity.hascycle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 3/16/26 23:51
 */
public class HasCycle_dfs {

    List<Integer>[] graph;
    int[] c; // 状态数组：0=未访问, -1=访问中, 1=已安全

    public boolean hasCycle(int n, int[][] edges) {
        graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
        }
        c = new int[n];
        for (int i = 0; i < n; i++) {
            if (c[i] == 0 && dfs(i)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(int x) {
        c[x] = -1;
        for (int y : graph[x]) {
            if (c[y] == -1) {
                return true;
            }
            if (c[y] == 0 && dfs(y)) {
                return true;
            }
        }
        c[x] = 1;
        return false;
    }
}
