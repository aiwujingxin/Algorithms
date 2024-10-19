package knowledge.datastructure.graph.detectcycle.impl;

import knowledge.datastructure.graph.detectcycle.DetectCycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/30 17:26
 */
public class DetectCycle_dfs implements DetectCycle {

    // 记录一次递归堆栈中的节点
    boolean[] onPath;
    // 记录遍历过的节点，防止走回头路
    boolean[] visited;

    HashMap<Integer, List<Integer>> graph = new HashMap<>();

    @Override
    public boolean hasCycle(int n, int[][] edges) {
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[1]).add(edge[0]);
        }
        visited = new boolean[n];
        onPath = new boolean[n];
        for (int i = 0; i < n; i++) {
            // 遍历图中的所有节点
            if (traverse(i)) {
                return true;
            }
        }
        return false;
    }

    private boolean traverse(int s) {
        visited[s] = true;
        onPath[s] = true;
        for (int next : graph.get(s)) {
            if (onPath[next]) {
                return true;
            }
            if (!visited[next]) {
                if (traverse(next)) {
                    return true;
                }
            }
        }
        // 后序代码位置
        onPath[s] = false;
        return false;
    }
}
