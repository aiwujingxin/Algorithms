package leetCode.problems;

import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/24 17:15
 */
public class LeetCode743_bfs {

    public int networkDelayTime(int[][] times, int N, int K) {

        // build graph
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] t : times) {
            int from = t[0];
            int to = t[1];
            int weight = t[2];
            map.putIfAbsent(from, new HashMap<>());
            map.get(from).put(to, weight);
        }

        int[] res = new int[N + 1];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[K] = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{K, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int node = cur[0];
            int weight = cur[1];
            for (int next : map.getOrDefault(node, new HashMap<>()).keySet()) {
                int w = map.get(node).get(next);
                if (w + weight < res[next]) {
                    res[next] = w + weight;
                    queue.offer(new int[]{next, w + weight});
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= N; ++i) {
            if (res[i] == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max, res[i]);
        }
        return max;
    }
}
