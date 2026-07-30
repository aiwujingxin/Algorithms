package leetcode.problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 7/31/26 04:10
 * @description 1928. 规定时间内到达终点的最小花费
 */
public class LeetCode1928_SPFA {

    private static final int INF = 0x3f3f3f3f;

    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        List<List<int[]>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
            graph.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }

        // dist[city][time]: 恰好使用 time 时间到达 city 的最小费用。
        int[][] dist = new int[n][maxTime + 1];
        boolean[][] inQueue = new boolean[n][maxTime + 1];
        for (int[] row : dist) {
            Arrays.fill(row, INF);
        }

        Queue<int[]> queue = new ArrayDeque<>();
        dist[0][0] = passingFees[0];
        inQueue[0][0] = true;
        queue.offer(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] state = queue.poll();
            int city = state[0], time = state[1];
            inQueue[city][time] = false;

            for (int[] edge : graph.get(city)) {
                int next = edge[0], nextTime = time + edge[1];
                if (nextTime > maxTime) continue;

                int nextCost = dist[city][time] + passingFees[next];
                if (nextCost < dist[next][nextTime]) {
                    dist[next][nextTime] = nextCost;
                    if (!inQueue[next][nextTime]) {
                        inQueue[next][nextTime] = true;
                        queue.offer(new int[]{next, nextTime});
                    }
                }
            }
        }

        int ans = INF;
        for (int time = 0; time <= maxTime; time++) {
            ans = Math.min(ans, dist[n - 1][time]);
        }
        return ans == INF ? -1 : ans;
    }
}
