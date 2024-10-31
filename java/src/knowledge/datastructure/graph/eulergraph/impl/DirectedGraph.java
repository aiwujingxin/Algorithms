package knowledge.datastructure.graph.eulergraph.impl;

import knowledge.datastructure.graph.eulergraph.EulerGraph;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 10/27/24 00:13
 */
public class DirectedGraph implements EulerGraph {

    private List<Integer>[] graph; // 图的邻接表表示
    private int n;                 // 顶点数
    private boolean[] visited;     // 访问标记数组
    private int[] outDegree;       // 顶点的出度

    // 判断图是否是欧拉回路
    public boolean isEulerCircuit(int n, int[][] edges) {
        this.graph = new List[n];
        this.n = n;
        this.visited = new boolean[n];
        // 顶点的入度
        int[] inDegree = new int[n];
        this.outDegree = new int[n];
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
        }
        // 初始化入度和出度
        for (int u = 0; u < n; u++) {
            for (int v : graph[u]) {
                outDegree[u]++;
                inDegree[v]++;
            }
        }
        // 检查所有顶点的入度和出度是否相等
        for (int i = 0; i < n; i++) {
            if (inDegree[i] != outDegree[i]) {
                return false; // 存在入度和出度不等的顶点
            }
        }

        // 检查图是否强连通
        return isStronglyConnected();
    }

    // 检查图是否强连通
    private boolean isStronglyConnected() {
        // 寻找一个出度不为0的顶点作为起点
        int start = -1;
        for (int i = 0; i < n; i++) {
            if (outDegree[i] > 0) {
                start = i;
                break;
            }
        }

        // 如果没有边，视为强连通
        if (start == -1) return true;

        // 从起点进行一次DFS，标记访问的顶点
        Arrays.fill(visited, false);
        dfs(start);

        // 检查所有出度不为0的顶点是否都访问到了
        for (int i = 0; i < n; i++) {
            if (outDegree[i] > 0 && !visited[i]) {
                return false;
            }
        }

        // 创建反向图并检查连通性
        List<Integer>[] reverseGraph = reverseGraph();
        Arrays.fill(visited, false);
        dfsReverse(start, reverseGraph);

        // 检查所有出度不为0的顶点在反向图中是否都访问到了
        for (int i = 0; i < n; i++) {
            if (outDegree[i] > 0 && !visited[i]) {
                return false;
            }
        }

        return true;
    }

    // 深度优先搜索，用于正向图
    private void dfs(int v) {
        visited[v] = true;
        for (int u : graph[v]) {
            if (!visited[u]) {
                dfs(u);
            }
        }
    }

    // 深度优先搜索，用于反向图
    private void dfsReverse(int v, List<Integer>[] reverseGraph) {
        visited[v] = true;
        for (int u : reverseGraph[v]) {
            if (!visited[u]) {
                dfsReverse(u, reverseGraph);
            }
        }
    }

    // 创建图的反向图
    private List<Integer>[] reverseGraph() {
        List<Integer>[] reverseGraph = new List[n];
        for (int i = 0; i < n; i++) {
            reverseGraph[i] = new ArrayList<>();
        }

        for (int u = 0; u < n; u++) {
            for (int v : graph[u]) {
                reverseGraph[v].add(u);
            }
        }

        return reverseGraph;
    }
}
