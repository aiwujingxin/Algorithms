package leetcode.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/21 22:21
 */
public class LeetCode787_SPFA {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int INF = 0x3f3f3f3f;
        int[][] g = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(g[i], INF);
        }
        for (int[] flight : flights) {
            g[flight[0]][flight[1]] = flight[2];
        }
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while (k-- >= 0) {
            int[] clone = dist.clone();
            int size = q.size();
            while (size-- > 0) {
                int node = q.poll();
                for (int i = 0; i < n; i++) {
                    int tmp = clone[node] + g[node][i];
                    if (tmp < dist[i]) {
                        dist[i] = tmp;
                        q.add(i);
                    }
                }
            }
        }
        return dist[dst] >= INF ? -1 : dist[dst];
    }
}
