package leetcode.problems.lists.lcp;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 7/31/26 04:10
 * @description LCP 35. 电动车游城市
 */
public class LCP35_SPFA {

    private static final int INF = 0x3f3f3f3f;

    public int electricCarPlan(int[][] paths, int cnt, int start, int end, int[] charge) {
        int n = charge.length;
        List<List<int[]>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] path : paths) {
            graph.get(path[0]).add(new int[]{path[1], path[2]});
            graph.get(path[1]).add(new int[]{path[0], path[2]});
        }

        // dist[city][power]: 到达城市且剩余 power 电量的最短时间。
        int[][] dist = new int[n][cnt + 1];
        boolean[][] inQueue = new boolean[n][cnt + 1];
        for (int[] row : dist) {
            Arrays.fill(row, INF);
        }

        Queue<int[]> queue = new ArrayDeque<>();
        dist[start][0] = 0;
        inQueue[start][0] = true;
        queue.offer(new int[]{start, 0});

        while (!queue.isEmpty()) {
            int[] state = queue.poll();
            int city = state[0], power = state[1];
            inQueue[city][power] = false;

            if (power < cnt) {
                relax(
                        city, power + 1, dist[city][power] + charge[city],
                        dist, inQueue, queue
                );
            }
            for (int[] edge : graph.get(city)) {
                int next = edge[0], need = edge[1];
                if (power >= need) {
                    relax(
                            next, power - need, dist[city][power] + need,
                            dist, inQueue, queue
                    );
                }
            }
        }

        int ans = INF;
        for (int power = 0; power <= cnt; power++) {
            ans = Math.min(ans, dist[end][power]);
        }
        return ans == INF ? -1 : ans;
    }

    private void relax(
            int city,
            int power,
            int nextDistance,
            int[][] dist,
            boolean[][] inQueue,
            Queue<int[]> queue
    ) {
        if (nextDistance < dist[city][power]) {
            dist[city][power] = nextDistance;
            if (!inQueue[city][power]) {
                inQueue[city][power] = true;
                queue.offer(new int[]{city, power});
            }
        }
    }
}
