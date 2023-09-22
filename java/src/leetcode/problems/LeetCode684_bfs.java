package leetcode.problems;

import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/24 16:34
 */
public class LeetCode684_bfs {

    Map<Integer, Set<Integer>> graph;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            if (bfs(edge[0], edge[1])) {
                return edge;
            }
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        return new int[]{-1, -1};
    }

    private boolean bfs(int src, int target) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        Set<Integer> visited = new HashSet<>();
        visited.add(src);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == target) {
                return true;
            }
            for (int next : graph.get(cur)) {
                if (visited.add(next)) {
                    queue.offer(next);
                }
            }
        }
        return false;
    }
}
