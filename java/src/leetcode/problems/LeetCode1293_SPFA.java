package leetcode.problems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 7/31/26 04:10
 * @description 1293. 网格中的最短路径
 */
public class LeetCode1293_SPFA {

    private static final int INF = 0x3f3f3f3f;
    private static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        if (k >= m + n - 3) return m + n - 2;

        // dist[row][col][remaining]: 到达位置且剩余 remaining 次消除机会的最短步数。
        int[][][] dist = new int[m][n][k + 1];
        boolean[][][] inQueue = new boolean[m][n][k + 1];
        for (int[][] matrix : dist) {
            for (int[] row : matrix) {
                Arrays.fill(row, INF);
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        dist[0][0][k] = 0;
        inQueue[0][0][k] = true;
        queue.offer(new int[]{0, 0, k});

        while (!queue.isEmpty()) {
            int[] state = queue.poll();
            int row = state[0], col = state[1], remaining = state[2];
            inQueue[row][col][remaining] = false;

            for (int[] dir : DIRS) {
                int nextRow = row + dir[0], nextCol = col + dir[1];
                if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n) continue;

                int nextRemaining = remaining - grid[nextRow][nextCol];
                if (nextRemaining < 0) continue;

                int nextDistance = dist[row][col][remaining] + 1;
                if (nextDistance < dist[nextRow][nextCol][nextRemaining]) {
                    dist[nextRow][nextCol][nextRemaining] = nextDistance;
                    if (!inQueue[nextRow][nextCol][nextRemaining]) {
                        inQueue[nextRow][nextCol][nextRemaining] = true;
                        queue.offer(new int[]{nextRow, nextCol, nextRemaining});
                    }
                }
            }
        }

        int ans = INF;
        for (int remaining = 0; remaining <= k; remaining++) {
            ans = Math.min(ans, dist[m - 1][n - 1][remaining]);
        }
        return ans == INF ? -1 : ans;
    }
}
