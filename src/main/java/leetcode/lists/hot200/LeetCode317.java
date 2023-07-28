package leetcode.lists.hot200;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/22 18:20
 */
public class LeetCode317 {
    public int shortestDistance(int[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        int mark = 0;
        int[][] totalDist = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res = bfs(grid, totalDist, i, j, mark);
                    // 每次遍历搜索完一个建筑物，这个标记减一，表示所有空地被遍历一次了
                    mark--;
                    if (res == Integer.MAX_VALUE) {
                        return -1;
                    }
                }
            }
        }
        return res;
    }

    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int bfs(int[][] grid, int[][] totalDist, int i, int j, int mark) {
        int res = Integer.MAX_VALUE;

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{i, j, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int currDist = cur[2];
            for (int[] dir : dirs) {
                int row = cur[0] + dir[0];
                int col = cur[1] + dir[1];
                if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == mark) {
                    int dist = currDist + 1;
                    // (3) 在搜索的同时将每一个空格到每一个建筑物的距离进行累加
                    totalDist[row][col] += dist;
                    // (4) 取空格到所有建筑物的最小距离
                    res = Math.min(res, totalDist[row][col]);
                    queue.add(new int[]{row, col, dist});
                    // 和 mark 标识对应
                    grid[row][col]--;
                }
            }
        }
        return res;
    }
}
