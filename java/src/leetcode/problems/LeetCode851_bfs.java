package leetcode.problems;


import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/1 16:32
 */
public class LeetCode851_bfs {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        int[] ans = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            ans[i] = i;
            map.put(i, new ArrayList<>());
        }

        int[] degree = new int[n];
        for (int[] r : richer) {
            map.get(r[0]).add(r[1]);
            degree[r[1]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int next : map.get(node)) {
                // 将 node 已找到的最安静富人传递给 next
                if (quiet[ans[node]] < quiet[ans[next]]) {
                    ans[next] = ans[node];
                }

                if (--degree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return ans;
    }
}
