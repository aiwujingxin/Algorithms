package leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/15 21:43
 */
public class LeetCode994 {

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        Queue<int[]> queue = new LinkedList<>();

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        if (count == 0) {
            return 0;
        }
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (count == 0) {
                return step;
            }
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int nx = cur[0] + dir[0];
                    int ny = cur[1] + dir[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                        continue;
                    }
                    if (grid[nx][ny] == 1) {
                        if (visited[nx][ny]) {
                            continue;
                        }
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                        count--;
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
