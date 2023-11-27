package leetcode.problems;

import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/27 20:43
 * @description 贪心 确定性决策 格子
 */
public class LeetCode407 {

    public int trapRainWater(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < n; i++) {
            queue.add(new int[]{0, i, heights[0][i]});
            queue.add(new int[]{m - 1, i, heights[m - 1][i]});
            visited[0][i] = visited[m - 1][i] = true;
        }
        for (int i = 1; i < m - 1; i++) {
            queue.add(new int[]{i, 0, heights[i][0]});
            queue.add(new int[]{i, n - 1, heights[i][n - 1]});
            visited[i][0] = visited[i][n - 1] = true;
        }
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int ans = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0], y = poll[1], h = poll[2];
            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                if (h > heights[nx][ny]) {
                    ans += h - heights[nx][ny];
                }
                queue.add(new int[]{nx, ny, Math.max(heights[nx][ny], h)});
                visited[nx][ny] = true;
            }
        }
        return ans;
    }
}
