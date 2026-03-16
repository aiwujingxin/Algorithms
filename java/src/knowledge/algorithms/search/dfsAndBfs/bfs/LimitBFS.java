package knowledge.algorithms.search.dfsAndBfs.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 3/17/26 00:06
 */
public class LimitBFS {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    /**
     * 寻找一条从左上角到右下角的路径，使得路径上经过的格子的 最大值 尽可能小。
     * 返回这个最小的最大值。
     */
    public int bottleneckBfs(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        // 1. 确定二分的上下界
        int left = 0, right = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                right = Math.max(right, grid[i][j]);
            }
        }

        int ans = right;
        // 2. 二分答案
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 如果允许的最大高度是 mid，能否走到终点？
            if (check(grid, mid)) {
                ans = mid;       // 能走到，记录答案
                right = mid - 1; // 尝试寻找更小的瓶颈值
            } else {
                left = mid + 1;  // 走不到，说明门槛太低了，必须提高阈值
            }
        }
        return ans;
    }

    // 3. 验证函数：只允许走 <= limit 的格子，能否从 (0,0) 走到 (m-1, n-1)
    private boolean check(int[][] grid, int limit) {
        // 起点本身就超过了限制，直接失败
        if (grid[0][0] > limit) return false;

        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0, 0});
        vis[0][0] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];

            if (r == m - 1 && c == n - 1) return true; // 到达终点

            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                // 核心过滤条件：不仅不能越界、不能重复访问，且格子高度必须 <= limit
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !vis[nr][nc] && grid[nr][nc] <= limit) {
                    vis[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }
        return false;
    }

}
