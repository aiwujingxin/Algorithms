package leetcode.hot100;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/10 16:06
 */
public class LeetCode200_bfs {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] node = queue.poll();
                        int m = node[0];
                        int n = node[1];
                        if (m - 1 >= 0 && grid[m - 1][n] == '1') {
                            grid[m - 1][n] = '0';
                            queue.add(new int[]{m - 1, n});
                        }
                        if (n - 1 >= 0 && grid[m][n - 1] == '1') {
                            grid[m][n - 1] = '0';
                            queue.add(new int[]{m, n - 1});
                        }
                        if (m + 1 < grid.length && grid[m + 1][n] == '1') {
                            grid[m + 1][n] = '0';
                            queue.add(new int[]{m + 1, n});
                        }
                        if (n + 1 < grid[0].length && grid[m][n + 1] == '1') {
                            grid[m][n + 1] = '0';
                            queue.add(new int[]{m, n + 1});
                        }
                    }
                }
            }
        }
        return count;
    }
}
