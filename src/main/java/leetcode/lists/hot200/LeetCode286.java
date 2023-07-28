package leetcode.lists.hot200;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/12 16:23
 */
public class LeetCode286 {

    public void wallsAndGates(int[][] rooms) {
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        if (rooms == null || rooms.length == 0) {
            return;
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int row = node[0];
            int col = node[1];
            for (int[] dir : dirs) {
                int x = row + dir[0];
                int y = col + dir[1];
                if (x < 0 || y < 0 || x > rooms.length - 1 || y > rooms[0].length - 1 || rooms[x][y] != Integer.MAX_VALUE) {
                    continue;
                }
                // 转移
                rooms[x][y] = rooms[row][col] + 1;
                queue.add(new int[]{x, y});
            }
        }
    }
}

