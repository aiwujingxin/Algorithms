package knowledge.algorithms.search.bfs;

import leetcode.problems.LeetCode1162;
import leetcode.problems.LeetCode1765;
import leetcode.problems.LeetCode542;
import leetcode.problems.LeetCode994;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 3/17/26 00:04
 * @see LeetCode542       01 矩阵
 * @see LeetCode994       腐烂的橘子
 * @see LeetCode1162      地图分析
 * @see LeetCode1765      最高的水域
 */
public class MultiBFS {

    public int[][] multiSourceBfs(int[][] grid) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        // 1. 初始化：将所有源点加入队列，非源点距离设为 -1 (或 INF)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) { // 假设 1 是源点
                    dist[i][j] = 0;
                    q.add(new int[]{i, j});
                } else {
                    dist[i][j] = -1; // -1 表示未访问
                }
            }
        }
        // 2. 标准 BFS 向外扩散
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n || dist[nr][nc] != -1) {
                    continue;
                }
                // 更新距离并入队
                dist[nr][nc] = dist[r][c] + 1;
                q.add(new int[]{nr, nc});
            }
        }
        return dist;
    }
}
