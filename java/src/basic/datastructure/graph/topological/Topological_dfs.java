package basic.datastructure.graph.topological;

import basic.datastructure.graph.Topological;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/31 18:19
 */
public class Topological_dfs implements Topological {

    List<Integer> postorder = new ArrayList<>();
    boolean[] onPath;
    boolean[] visited;
    boolean hasCycle = false;

    public int[] findOrder(int n, int[][] edges) {
        List<Integer>[] graph = buildGraph(n, edges);

        visited = new boolean[n];
        onPath = new boolean[n];

        for (int i = 0; i < n; i++) {
            traverse(graph, i);
        }

        // 有环图无法进行拓扑排序
        if (hasCycle) {
            return new int[]{};
        }
        // 逆后序遍历结果即为拓扑排序结果
        Collections.reverse(postorder);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = postorder.get(i);
        }
        return res;
    }

    void traverse(List<Integer>[] graph, int s) {
        if (onPath[s]) {
            hasCycle = true;
        }

        if (visited[s] || hasCycle) {
            return;
        }

        visited[s] = true;
        onPath[s] = true;
        for (int t : graph[s]) {
            traverse(graph, t);
        }
        // 后序代码位置
        postorder.add(s);
        onPath[s] = false;
    }

    List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : prerequisites) {
            int from = edge[1], to = edge[0];
            graph[from].add(to);
        }
        return graph;
    }
}
