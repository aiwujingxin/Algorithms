package leetcode.problems;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 9/19/25 01:10
 */
public class LeetCode1293 {
    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;

        // 如果k足够大，可以直接走最短路径
        if (k >= m + n - 3) {
            return m + n - 2;
        }

        // dist[x][y][rem] 表示到达(x,y)且剩余rem次消除机会的最小步数
        int[][][] dist = new int[m][n][k + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }

        // 优先队列：按照步数排序
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[3] - b[3]);
        dist[0][0][k] = 0;
        pq.offer(new int[]{0, 0, k, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int x = curr[0], y = curr[1], rem = curr[2], steps = curr[3];

            // 如果当前步数不是最优，跳过
            if (steps > dist[x][y][rem]) {
                continue;
            }

            // 到达终点
            if (x == m - 1 && y == n - 1) {
                return steps;
            }

            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int newRem = rem;
                    int newSteps = steps + 1;

                    if (grid[nx][ny] == 1) {
                        newRem--;
                    }

                    // 如果剩余消除次数不足，或者不是更优路径，跳过
                    if (newRem < 0 || newSteps >= dist[nx][ny][newRem]) {
                        continue;
                    }

                    dist[nx][ny][newRem] = newSteps;
                    pq.offer(new int[]{nx, ny, newRem, newSteps});
                }
            }
        }

        return -1;
    }
}
