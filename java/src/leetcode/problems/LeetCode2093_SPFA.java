package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/3 12:27
 * @description spfa求带限制的最短路
 */
public class LeetCode2093_SPFA {

    //https://leetcode.cn/problems/minimum-cost-to-reach-city-with-discounts/solutions/1143195/py3-spfaqiu-dai-xian-zhi-de-zui-duan-lu-df7qj/

    public int minimumCost(int n, int[][] highways, int discounts) {
        List<int[]>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] h : highways) {
            graph[h[0]].add(new int[]{h[1], h[2]});
            graph[h[1]].add(new int[]{h[0], h[2]});
        }

        int[][] dp = new int[n][discounts + 1];
        boolean[][] vis = new boolean[n][discounts + 1];

        for (int[] d : dp) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        dp[0][discounts] = 0;
        vis[0][discounts] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, discounts});

        while (!queue.isEmpty()) {
            int[] curPair = queue.poll();
            int u = curPair[0];
            int cnt = curPair[1];
            vis[u][cnt] = false;

            for (int[] edge : graph[u]) {
                int next = edge[0];
                int cost = edge[1];

                // Without using discount
                if (dp[next][cnt] > dp[u][cnt] + cost) {
                    dp[next][cnt] = dp[u][cnt] + cost;

                    if (!vis[next][cnt]) {
                        vis[next][cnt] = true;
                        queue.offer(new int[]{next, cnt});
                    }
                }

                // Using discount
                if (cnt > 0) {
                    if (dp[next][cnt - 1] > dp[u][cnt] + cost / 2) {
                        dp[next][cnt - 1] = dp[u][cnt] + cost / 2;

                        if (!vis[next][cnt - 1]) {
                            vis[next][cnt - 1] = true;
                            queue.offer(new int[]{next, cnt - 1});
                        }
                    }
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
