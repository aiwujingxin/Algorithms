package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 10/19/24 21:44
 */
public class LeetCode787_dij {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] dis = new int[n][k + 1];
        boolean[][] vis = new boolean[n][k + 1];
        List<int[]>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
            g[i] = new ArrayList<>();
        }
        for (int[] arr : flights) {
            int x = arr[0], y = arr[1], w = arr[2];
            g[x].add(new int[]{y, w});
        }
        dis[src][0] = 0;
        // 0: 当前城市
        // 1: 已使用的中转次数 (stops)
        // 2: 当前总代价
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        pq.add(new int[]{src, 0, 0});
        while (!pq.isEmpty()) {
            int[] pos = pq.poll();
            int u = pos[0], layer = pos[1], cost = pos[2];
            // 优先队列保证了第一次遇到 dst 时，cost 就是最小的
            if (u == dst) return cost;
            if (vis[u][layer]) continue;
            vis[u][layer] = true;
            for (int[] next : g[u]) {
                int v = next[0], w = next[1];
                // 1、接着继续中转（下一跳不是终点，且中转次数还没达到上限 k）
                if (v != dst && layer < k) {
                    if (cost + w < dis[v][layer + 1]) {
                        dis[v][layer + 1] = cost + w;
                        pq.add(new int[]{v, layer + 1, cost + w});
                    }
                }
                // 2、可以直达（下一跳就是终点，不需要增加中转次数）
                if (v == dst) {
                    if (cost + w < dis[v][layer]) {
                        dis[v][layer] = cost + w;
                        pq.add(new int[]{v, layer, cost + w});
                    }
                }
            }
        }
        return -1;
    }
}
