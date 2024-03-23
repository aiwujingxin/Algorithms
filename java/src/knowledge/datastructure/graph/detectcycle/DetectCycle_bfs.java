package knowledge.datastructure.graph.detectcycle;

import knowledge.datastructure.graph.DetectCycle;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/30 17:42
 */
public class DetectCycle_bfs implements DetectCycle {

    @Override
    public boolean hasCycle(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int[] degree = new int[n];
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }
        if (queue.isEmpty()) {
            return true;
        }
        // 记录遍历的节点个数
        int count = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;
            for (int next : graph.get(node)) {
                degree[next]--;
                if (degree[next] == 0) {
                    queue.add(next);
                }
            }
        }
        return count != n;
    }
}
