package leetcode.problems;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/12 22:37
 */
public class LeetCode1162 {

    //https://leetcode.com/problems/as-far-from-land-as-possible/discuss/360996/A-very-typical-O(v)-BFS-JAVA-17-ms-faster-than-100.00
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int maxDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int level = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] start = queue.poll();
                int x = start[0];
                int y = start[1];
                for (int[] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && !visited[newX][newY] && grid[newX][newY] == 0) {
                        visited[newX][newY] = true;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
            level++;
        }
        return level <= 0 ? -1 : level;
    }
}
