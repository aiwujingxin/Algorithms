package leetcode;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/31 18:05
 */
public class LeetCode2192_topo {

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<Integer>[] parents = new HashSet[n];
        int[] indegrees = new int[n];
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
            parents[i] = new HashSet<>();
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            parents[edge[1]].add(edge[0]);
            indegrees[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int next : graph.get(cur)) {
                    for (int parent : parents[cur]) {
                        parents[next].add(parent);
                    }
                    indegrees[next]--;
                    if (indegrees[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>(parents[i]);
            Collections.sort(list);
            res.add(list);
        }
        return res;
    }
}


