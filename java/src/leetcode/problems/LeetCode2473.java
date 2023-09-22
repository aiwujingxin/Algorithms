package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/6 17:15
 */
public class LeetCode2473 {

    public long[] minCost(int n, int[][] roads, int[] appleCost, int k) {
        List<int[]>[] graph = new List[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] road : roads) {
            int u = road[0] - 1;
            int v = road[1] - 1;
            int c = road[2];
            graph[u].add(new int[]{v, c});
            graph[v].add(new int[]{u, c});
        }

        long[] result = new long[n];

        for (int i = 0; i < n; i++) {
            result[i] = dijkstra(i, n, graph, appleCost, k);
        }
        return result;
    }

    private long dijkstra(int source, int n, List<int[]>[] graph, int[] appleCost, int k) {
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[source] = 0;
        int ans = Integer.MAX_VALUE;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        queue.add(new int[]{0, source});
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int d = node[0];
            int cur = node[1];

            ans = Math.min(ans, (k + 1) * d + appleCost[cur]);

            if (dis[cur] < d) {
                continue;
            }
            for (int[] neighbor : graph[cur]) {
                int nxt = neighbor[0];
                int cost = neighbor[1];
                if (d + cost < dis[nxt]) {
                    queue.add(new int[]{d + cost, nxt});
                    dis[nxt] = d + cost;
                }
            }
        }
        return ans;
    }
}
