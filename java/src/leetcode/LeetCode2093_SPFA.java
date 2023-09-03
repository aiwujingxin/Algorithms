package leetcode;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/3 12:27
 * spfa求带限制的最短路
 */
public class LeetCode2093_SPFA {

    //https://leetcode.cn/problems/minimum-cost-to-reach-city-with-discounts/solutions/1143195/py3-spfaqiu-dai-xian-zhi-de-zui-duan-lu-df7qj/

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
        boolean[][] state = new boolean[n][discounts + 1];

        for (int[] d : dp) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        dp[0][discounts] = 0;
        state[0][discounts] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, discounts});

        while (!queue.isEmpty()) {
            int[] curPair = queue.poll();
            int cur = curPair[0];
            int cnt = curPair[1];
            state[cur][cnt] = false;

            for (int[] nextPair : graph[cur]) {
                int next = nextPair[0];
                int cost = nextPair[1];

                // Without using discount
                if (dp[next][cnt] > dp[cur][cnt] + cost) {
                    dp[next][cnt] = dp[cur][cnt] + cost;

                    if (!state[next][cnt]) {
                        state[next][cnt] = true;
                        queue.offer(new int[]{next, cnt});
                    }
                }

                // Using discount
                if (cnt > 0) {
                    if (dp[next][cnt - 1] > dp[cur][cnt] + cost / 2) {
                        dp[next][cnt - 1] = dp[cur][cnt] + cost / 2;

                        if (!state[next][cnt - 1]) {
                            state[next][cnt - 1] = true;
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
