package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/16 22:36
 */
public class LeetCode1926 {

    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] vis = new boolean[m][n];
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(entrance);
        vis[entrance[0]][entrance[1]] = true;
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                int x = node[0];
                int y = node[1];
                if ((x == 0 || x == m - 1 || y == 0 || y == n - 1) && x * 100 + y != entrance[0] * 100 + entrance[1]) {
                    return step;
                }
                for (int[] dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                        continue;
                    }
                    if (maze[nx][ny] == '+' || vis[nx][ny]) {
                        continue;
                    }
                    queue.add(new int[]{nx, ny});
                    vis[nx][ny] = true;
                }
            }
            step++;
        }
        return -1;
    }
}
