package leetcode.problems;


import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/11 00:28
 */
public class LeetCode2045 {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        int[][] dist = new int[n + 1][2];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[1][1] = Integer.MAX_VALUE;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0});

        while (dist[n][1] == Integer.MAX_VALUE) {
            int[] p = q.poll();
            for (int y : graph.get(p[0])) {
                int d = p[1] + 1;
                if (d < dist[y][0]) {
                    dist[y][0] = d;
                    q.add(new int[]{y, d});
                } else if (dist[y][0] < d && d < dist[y][1]) {
                    dist[y][1] = d;
                    q.add(new int[]{y, d});
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < dist[n][1]; i++) {
            if (ans % (change * 2) >= change) {
                ans += change * 2 - ans % (change * 2);
            }
            ans += time;
        }
        return ans;
    }
}
