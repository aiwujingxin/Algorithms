package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/7 16:56
 */
public class LeetCode934 {

    int[][] grid;
    int[][] step;
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int shortestBridge(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        this.grid = grid;
        this.step = new int[m][n];
        boolean found = false;
        for (int i = 0; i < m; i++) {
            if (found) {
                break;
            }
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j);
                    found = true;
                    break;
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                step[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    int t = bfs(i, j);
                    if (t == -1) {
                        continue;
                    }
                    res = Math.min(res, t);
                }
            }
        }
        return res;
    }

    private int bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j, 0});
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0];
            int y = node[1];
            visited[x][y] = true;
            if (node[2] >= step[x][y]) {
                continue;
            }
            step[x][y] = node[2];
            if (grid[x][y] == 1) {
                return node[2];
            }
            for (int[] dir : dirs) {
                int nx = node[0] + dir[0];
                int ny = node[1] + dir[1];
                if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length || visited[nx][ny] || grid[nx][ny] == 2) {
                    continue;
                }
                queue.add(new int[]{nx, ny, node[2] + 1});
            }
        }
        return -1;
    }

    private void dfs(int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return;
        }
        grid[i][j] = 2;
        dfs(i + 1, j);
        dfs(i, j + 1);
        dfs(i - 1, j);
        dfs(i, j - 1);
    }

}
