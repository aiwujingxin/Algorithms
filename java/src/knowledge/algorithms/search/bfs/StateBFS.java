package knowledge.algorithms.search.bfs;

import leetcode.problems.LeetCode864;

import java.util.LinkedList;
import java.util.Queue;


/**
 * @author wujingxinit@outlook.com
 * @date 3/17/26 00:07
 * @see LeetCode864
 */
public class StateBFS {

    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    /**
     * 迷宫寻宝：S是起点，E是终点，小写字母是钥匙，大写字母是对应的门。
     * 求拿到所有钥匙走到终点的最短步数。
     */
    public int stateSpaceBfs(char[][] grid, int keyCount) {
        int m = grid.length, n = grid[0].length;
        // vis 数组升维：vis[r][c][state]，state 是一个二进制数，表示拥有的钥匙集合
        boolean[][][] vis = new boolean[m][n][1 << keyCount];
        Queue<int[]> q = new LinkedList<>();

        // 1. 寻找起点
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'S') {
                    q.add(new int[]{i, j, 0, 0}); // {r, c, keys_mask, steps}
                    vis[i][j][0] = true;
                }
            }
        }

        // 2. 状态空间搜索
        int targetState = (1 << keyCount) - 1; // 所有钥匙都拿到的状态
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1], mask = curr[2], steps = curr[3];

            // 达到终点且钥匙集齐
            if (grid[r][c] == 'E' && mask == targetState) {
                return steps;
            }

            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] == '#') continue; // 越界或撞墙

                char cell = grid[nr][nc];
                int nxtMask = mask;

                // 如果是门，检查是否有对应的钥匙 (利用位运算)
                if (cell >= 'A' && cell <= 'Z') {
                    int requiredKey = cell - 'A';
                    if ((mask & (1 << requiredKey)) == 0) continue; // 没钥匙，过不去
                }

                // 如果是钥匙，捡起它 (更新 mask)
                if (cell >= 'a' && cell <= 'z') {
                    nxtMask |= (1 << (cell - 'a'));
                }

                // 如果这个 (坐标 + 状态) 组合没来过，入队
                if (!vis[nr][nc][nxtMask]) {
                    vis[nr][nc][nxtMask] = true;
                    q.add(new int[]{nr, nc, nxtMask, steps + 1});
                }
            }
        }
        return -1; // 无法到达
    }

}
