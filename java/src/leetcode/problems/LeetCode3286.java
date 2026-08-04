package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 7/22/25 22:21
 */
public class LeetCode3286 {

    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size(), n = grid.get(0).size();
        Boolean[][][] memo = new Boolean[m][n][health + 1];
        return dfs(grid, 0, 0, m, n, health, memo);
    }

    boolean dfs(List<List<Integer>> grid, int i, int j, int m, int n, int health, Boolean[][][] memo) {
        if (i < 0 || j < 0 || i >= m || j >= n) return false;
        int h = health - grid.get(i).get(j);            // 踩进(i,j)后的剩余血
        if (h <= 0) return false;                       // 血耗尽,走不通
        if (i == m - 1 && j == n - 1) return true;      // 活着到终点
        if (memo[i][j][h] != null) return memo[i][j][h]; // 命中:计算中占位 或 已确定
        memo[i][j][h] = false;                          // ★ 占位:绕回本状态视为走不通(替代 vs)
        boolean res = false;
        for (int[] d : dirs)
            if (dfs(grid, i + d[0], j + d[1], m, n, h, memo)) {
                res = true;
                break;
            }
        memo[i][j][h] = res;                            // 回填真值
        return res;
    }

    public boolean findSafeWalk_dij(List<List<Integer>> grid, int health) {
        int m = grid.size(), n = grid.get(0).size();
        int[][] cost = new int[m][n];
        for (int[] r : cost) Arrays.fill(r, Integer.MAX_VALUE);
        cost[0][0] = grid.get(0).get(0);
        // 元素: {x, y, 累计cost}, 按cost小根堆
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        q.add(new int[]{0, 0, cost[0][0]});
        while (!q.isEmpty()) {
            int[] t = q.poll();
            int x = t[0], y = t[1], c = t[2];
            if (c > cost[x][y]) continue;                   // 惰性跳过过时副本
            for (int d = 0; d < 4; d++) {
                int nx = x + dirs[d][0], ny = y + dirs[d][1];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                int nc = c + grid.get(nx).get(ny);
                if (nc < cost[nx][ny]) {

                    cost[nx][ny] = nc;

                    q.add(new int[]{nx, ny, nc});           // ★ 每次都 offer,堆 O(logV) 重排
                }
            }
        }
        return cost[m - 1][n - 1] < health;
    }

    public boolean findSafeWalk_01bfs(List<List<Integer>> grid, int health) {
        int m = grid.size(), n = grid.get(0).size();
        int[][] cost = new int[m][n];
        for (int[] r : cost) Arrays.fill(r, Integer.MAX_VALUE);
        cost[0][0] = grid.get(0).get(0);
        // 元素只存 {x, y},cost 查表即可
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] t = q.poll();
            int x = t[0], y = t[1], c = cost[x][y];
            for (int d = 0; d < 4; d++) {
                int nx = x + dirs[d][0], ny = y + dirs[d][1];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                int nc = c + grid.get(nx).get(ny);
                if (nc < cost[nx][ny]) {
                    cost[nx][ny] = nc;

                    // BFS 01  权0→同档,插队头  权1→下一档,插队尾
                    if (grid.get(nx).get(ny) == 0) q.addFirst(new int[]{nx, ny});
                    else q.addLast(new int[]{nx, ny});
                }
            }
        }
        return cost[m - 1][n - 1] < health;
    }
}
