package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/3 11:42
 */
public class LeetCode2093_dijkstra {

    public int minimumCost(int n, int[][] highways, int discounts) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] h : highways) {
            graph[h[0]].add(new int[]{h[1], h[2]});
            graph[h[1]].add(new int[]{h[0], h[2]});
        }
        int[][] dp = new int[n][discounts + 1];
        for (int[] d : dp) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        // [idx][discount 次数][费用]
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] == o2[1] ? o1[2] - o2[2] : o1[1] - o2[1]);
        queue.add(new int[]{0, 0, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int from = cur[0];
            int disCnt = cur[1];
            int toll = cur[2];

            if (dp[from][disCnt] < toll) {
                continue;
            }

            for (int[] next : graph[from]) {
                int to = next[0];
                int nextToll = next[1];
                int d = dp[from][disCnt] + nextToll;
                if (d < dp[to][disCnt]) {
                    dp[to][disCnt] = d;
                    queue.add(new int[]{to, disCnt, d});
                }

                int dd = dp[from][disCnt] + nextToll / 2;
                if (disCnt + 1 <= discounts && dd < dp[to][disCnt + 1]) {
                    dp[to][disCnt + 1] = dd;
                    queue.add(new int[]{to, disCnt + 1, dd});
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= discounts; i++) {
            ans = Math.min(ans, dp[n - 1][i]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
