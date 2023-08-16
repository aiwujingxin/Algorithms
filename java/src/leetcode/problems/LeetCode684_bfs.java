package leetcode.problems;

import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/24 16:34
 */
public class LeetCode684_bfs {
    public int[] findRedundantConnection(int[][] edges) {

        int m = edges.length;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 1; i <= m; i++) {
            map.put(i, new HashSet<>());
        }

        for (int[] edge : edges) {
            if (bfs(map, edge[0], edge[1])) return edge;
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        return new int[]{-1, -1};
    }

    // search
    private boolean bfs(Map<Integer, Set<Integer>> map, int src, int target) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        Set<Integer> visited = new HashSet<>();
        visited.add(src);
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == target) return true;
            for (int next : map.get(cur)) {
                if (visited.add(next)) {
                    q.offer(next);
                }
            }
        }
        return false;
    }
}
