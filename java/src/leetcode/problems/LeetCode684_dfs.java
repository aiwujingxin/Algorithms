package leetcode.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/24 16:24
 */
public class LeetCode684_dfs {

    public int[] findRedundantConnection(int[][] edges) {
        int m = edges.length;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 1; i <= m; i++) {
            map.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            if (dfs(new HashSet<>(), map, edge[0], edge[1])) {
                return edge;
            }
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        return new int[]{-1, -1};
    }

    private boolean dfs(Set<Integer> visited, Map<Integer, Set<Integer>> map, int src, int target) {
        if (src == target) {
            return true;
        }
        visited.add(src);
        for (int next : map.get(src)) {
            if (!visited.contains(next)) {
                if (dfs(visited, map, next, target)) {
                    return true;
                }
            }
        }
        return false;
    }
}
