package leetcode.problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/23 12:59
 */
public class LeetCode2596 {

    public boolean checkValidGrid(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return true;
        }
        if (grid[0][0] != 0) {
            return false;
        }
        int m = grid.length;
        int n = grid[0].length;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (set.contains(grid[i][j])) {
                    return false;
                }
                set.add(grid[i][j]);
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        int next = 1;
        int target = m * n;
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;

        int[][] dirs = new int[][]{{-1, -2}, {-2, -1}, {1, -2}, {2, -1},
                {1, 2}, {2, 1}, {-1, 2}, {-2, 1}};
        while (!queue.isEmpty()) {
            if (next == target) {
                return true;
            }
            int[] node = queue.poll();
            boolean can = false;
            for (int[] dir : dirs) {
                int nx = node[0] + dir[0];
                int ny = node[1] + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny]) {
                    continue;
                }
                if (grid[nx][ny] == next) {
                    can = true;
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    next++;
                    break;
                }

            }
            if (!can) {
                return false;
            }
        }
        return false;
    }
}
