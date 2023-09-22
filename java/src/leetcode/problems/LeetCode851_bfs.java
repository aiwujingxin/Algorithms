package leetcode.problems;


import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/1 16:32
 */
public class LeetCode851_bfs {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] degree = new int[quiet.length];
        for (int[] r : richer) {
            graph.put(r[0], graph.getOrDefault(r[0], new ArrayList<>()));
            graph.get(r[0]).add(r[1]);
            degree[r[1]]++;
        }
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < quiet.length; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }
        int[] ans = new int[quiet.length];
        for (int i = 0; i < quiet.length; i++) {
            ans[i] = i;
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (graph.containsKey(cur)) {
                for (int next : graph.get(cur)) {
                    if (quiet[ans[cur]] < quiet[ans[next]]) {
                        ans[next] = ans[cur];
                    }
                    degree[next]--;
                    if (degree[next] == 0) {
                        queue.add(next);
                    }
                }
            }
        }
        return ans;
    }
}
