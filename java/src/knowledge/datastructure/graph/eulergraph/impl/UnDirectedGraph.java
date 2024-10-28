package knowledge.datastructure.graph.eulergraph.impl;

import knowledge.datastructure.graph.eulergraph.EulerGraph;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 10/19/24 21:55
 */
public class UnDirectedGraph implements EulerGraph {

    private List<Integer>[] g; // 邻接表表示的图
    private boolean[] visited;     // 访问标记数组
    int n;

    public boolean isEulerCircuit(int n, int[][] edges) {
        this.g = new List[n];
        this.n = n;
        this.visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        // 判断是否所有顶点的度数均为偶数
        for (int i = 0; i < n; i++) {
            if (g[i].size() % 2 != 0) {
                return false;
            }
        }
        return isConnected();
    }

    // 深度优先搜索用于判断图的连通性
    private void dfs(int v) {
        visited[v] = true;
        for (int u : g[v]) {
            if (!visited[u]) {
                dfs(u);
            }
        }
    }

    // 检查图是否连通
    private boolean isConnected() {
        // 寻找第一个度数不为0的顶点作为起始点
        int start = -1;
        for (int i = 0; i < n; i++) {
            if (!g[i].isEmpty()) {
                start = i;
                break;
            }
        }
        if (start == -1) {
            return true;
        }
        dfs(start);
        // 检查所有度数不为0的顶点是否都已访问
        for (int i = 0; i < n; i++) {
            if (!g[i].isEmpty() && !visited[i]) {
                return false;
            }
        }
        return true;
    }

}
