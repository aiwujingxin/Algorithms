package leetcode;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/19 17:51
 */
public class LeetCode310_topo {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        int[] degree = new int[n];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<>());
        }
        for (int[] e : edges) {
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
            degree[e[0]]++;
            degree[e[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                level.add(cur);
                for (int parent : map.get(cur)) {
                    degree[parent]--;
                    if (degree[parent] == 1) {
                        queue.add(parent);
                    }
                }
            }
            res = level;
        }
        return res;
    }
}
