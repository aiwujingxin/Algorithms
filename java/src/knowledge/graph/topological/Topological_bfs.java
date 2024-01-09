package knowledge.graph.topological;

import knowledge.graph.Topological;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/31 18:17
 */
public class Topological_bfs implements Topological {

    public int[] findOrder(int n, int[][] edges) {
        List<Integer>[] graph = new List[n];
        int[] indgree = new int[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : edges) {
            graph[edge[1]].add(edge[0]);
            indgree[edge[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indgree[i] == 0) {
                queue.add(i);
            }
        }
        int[] res = new int[n];
        int count = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            res[count] = cur;
            count++;
            for (int next : graph[cur]) {
                indgree[next]--;
                if (indgree[next] == 0) {
                    queue.add(next);
                }
            }
        }
        if (count != n) {
            return new int[]{};
        }
        return res;
    }
}
