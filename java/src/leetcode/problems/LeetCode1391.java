package leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 12/1/25 14:40
 */
public class LeetCode1391 {

    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // U, D, L, R 的偏移
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        // 街道类型与连通方向映射：U D L R
        int[][] conn = {
                {}, // 占位 0（不用）
                {0, 0, 1, 1}, // 1: L R
                {1, 1, 0, 0}, // 2: U D
                {0, 1, 1, 0}, // 3: D L
                {0, 1, 0, 1}, // 4: D R
                {1, 0, 1, 0}, // 5: U L
                {1, 0, 0, 1}  // 6: U R
        };
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];
        q.offer(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            if (x == m - 1 && y == n - 1) return true;
            if (vis[x][y]) continue;
            vis[x][y] = true;
            int[] c1 = conn[grid[x][y]];
            for (int d = 0; d < 4; d++) {
                if (c1[d] == 0) continue;
                int nx = x + dirs[d][0];
                int ny = y + dirs[d][1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || vis[nx][ny]) continue;
                int[] c2 = conn[grid[nx][ny]];
                int opposite = d ^ 1; // 0<->1, 2<->3
                if (c2[opposite] == 1) q.offer(new int[]{nx, ny});
            }
        }
        return false;
    }
}
