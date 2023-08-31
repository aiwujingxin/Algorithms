package basic.datastructure.graph.topological;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/31 18:17
 */
public class Topological_bfs {

    int[] indgree;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        indgree = new int[numCourses];
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indgree[i] == 0) {
                q.offer(i);
            }
        }

        // 记录拓扑排序结果
        int[] res = new int[numCourses];
        int count = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            // 弹出节点的顺序即为拓扑排序结果
            res[count] = cur;
            count++;
            for (int next : graph[cur]) {
                indgree[next]--;
                if (indgree[next] == 0) {
                    q.offer(next);
                }
            }
        }
        if (count != numCourses) {
            return new int[]{};
        }
        return res;
    }

    List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : prerequisites) {
            int from = edge[1], to = edge[0];
            graph[from].add(to);
            indgree[to]++;
        }
        return graph;
    }
}
