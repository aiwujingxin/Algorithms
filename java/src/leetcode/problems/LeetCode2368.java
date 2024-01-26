package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/26 12:52
 */
public class LeetCode2368 {

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<Integer>[] graph = new List[n];
        HashSet<Integer> set = new HashSet<>();
        for (int j : restricted) {
            set.add(j);
        }
        if (set.contains(0)) {
            return 0;
        }
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            if (set.contains(node)) {
                continue;
            }
            if (visited.contains(node)) {
                continue;
            }
            visited.add(node);
            for (int next : graph[node]) {
                queue.add(next);
            }
        }
        return visited.size();
    }
}
