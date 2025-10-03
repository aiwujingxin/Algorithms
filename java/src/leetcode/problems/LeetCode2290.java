package leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 7/22/25 22:23
 * @see LeetCode3286
 */
public class LeetCode2290 {

    public int minimumObstacles(int[][] grid) {
        return findSafeWalk(grid);
    }

    public int findSafeWalk(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dis = new int[n][m];
        for (int[] row : dis) Arrays.fill(row, -1);
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        // 小根堆：{cost, i, j}
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{grid[0][0], 0, 0});
        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            int cost = arr[0], i = arr[1], j = arr[2];
            if (dis[i][j] >= 0) continue;
            dis[i][j] = cost;
            for (int[] d : dirs) {
                int ii = i + d[0], jj = j + d[1];
                if (ii < 0 || jj < 0 || ii >= n || jj >= m) continue;
                if (dis[ii][jj] >= 0) continue;
                int nextCost = cost + grid[ii][jj];
                pq.offer(new int[]{nextCost, ii, jj});
            }
        }
        return dis[n - 1][m - 1];
    }
}
