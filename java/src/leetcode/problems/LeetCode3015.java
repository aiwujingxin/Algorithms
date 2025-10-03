package leetcode.problems;

import java.util.*;
import java.util.Arrays;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 8/17/25 23:12
 */
public class LeetCode3015 {

    public int[] countOfPairs(int n, int x, int y) {
        int[] ans = new int[n];
        List<Integer>[] g = new List[n + 1];
        for (int i = 1; i <= n; i++)
            g[i] = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            g[i].add(i + 1);
            g[i + 1].add(i);
        }
        g[x].add(y);
        g[y].add(x);

        // dist[i][j] 保存 i 到 j 的最短距离
        int[][] dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], -1);
            Queue<Integer> q = new ArrayDeque<>();
            q.add(i);
            dist[i][i] = 0;
            while (!q.isEmpty()) {
                int u = q.poll();
                for (int v : g[u]) {
                    if (dist[i][v] == -1) {
                        dist[i][v] = dist[i][u] + 1;
                        q.add(v);
                    }
                }
            }
        }

        // 统计每个距离的数量
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int d = dist[i][j];
                ans[d - 1] += 2; // (i,j) 和 (j,i)
            }
        }
        return ans;
    }
}
