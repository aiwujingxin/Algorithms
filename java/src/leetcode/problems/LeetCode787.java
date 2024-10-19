package leetcode.problems;

import java.util.*;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 10/19/24 21:44
 */
public class LeetCode787 {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] dis = new int[n + 1][k + 1];
        boolean[][] vis = new boolean[n + 1][k + 1];
        List<int[]>[] g = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
            g[i] = new ArrayList<>();
        }
        for (int[] arr : flights) {
            int x = arr[0], y = arr[1], w = arr[2];
            g[x].add(new int[]{y, w});
        }
        dis[src][k] = 0;
        // 0: 城市
        // 1：剩余的中转站次数
        // 2：代价
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        pq.add(new int[]{src, k, 0});
        while (!pq.isEmpty()) {
            int[] pos = pq.poll();
            int x = pos[0], restK = pos[1], cost = pos[2];
            if (x == dst) return cost;
            if (vis[x][restK]) continue;
            vis[x][restK] = true;
            for (int[] next : g[x]) {
                int y = next[0], w = next[1];
                // 1、接着继续中转
                if (y != dst && restK > 0) {
                    // dis[y][restK - 1] = cost + w;
                    pq.add(new int[]{y, restK - 1, cost + w});
                }
                // 2、可以直达
                if (y == dst && cost + w < dis[y][restK]) {
                    dis[y][restK] = cost + w;
                    pq.add(new int[]{y, restK, cost + w});
                }
            }
        }
        return -1;
    }
}
