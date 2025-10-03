package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 7/22/25 22:21
 */
public class LeetCode3286 {

    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        boolean[][] vs = new boolean[m][n];
        Boolean[][][] memo = new Boolean[m][n][health + 1];
        return dfs(grid, 0, 0, m, n, health, vs, memo);
    }

    public boolean dfs(List<List<Integer>> grid, int i, int j, int m, int n, int health, boolean[][] vs, Boolean[][][] memo) {
        if (i == m - 1 && j == n - 1 && health > grid.get(i).get(j)) return true;
        if (i < 0 || j < 0 || i >= m || j >= n || vs[i][j] || health <= 0) return false;
        if (memo[i][j][health] != null) return memo[i][j][health];
        vs[i][j] = true;
        boolean res = false;
        for (int[] dir : dirs) res |= dfs(grid, i + dir[0], j + dir[1], m, n, health - grid.get(i).get(j), vs, memo);
        vs[i][j] = false;
        memo[i][j][health] = res;
        return res;
    }

    public boolean findSafeWalk_dij(List<List<Integer>> grid, int health) {
        int m = grid.size(), n = grid.get(0).size();
        int[][] costs = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(costs[i], Integer.MAX_VALUE);
        }
        costs[0][0] = grid.get(0).get(0);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.add(new int[]{0, 0, costs[0][0]});
        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int i = cell[0], j = cell[1];
            for (int[] dir : dirs) {
                int ni = i + dir[0], nj = j + dir[1];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n && costs[i][j] + grid.get(ni).get(nj) < costs[ni][nj]) {
                    costs[ni][nj] = costs[i][j] + grid.get(ni).get(nj);
                    pq.add(new int[]{ni, nj, costs[ni][nj]});
                }
            }
        }
        return costs[m - 1][n - 1] < health;
    }

    public boolean findSafeWalk_01bfs(List<List<Integer>> grid, int health) {
        int m = grid.size(), n = grid.get(0).size();
        int[][] g = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) g[i][j] = grid.get(i).get(j);
        }
        // dist 记录到达 (i,j) 的最大剩余健康；初始化为 -1 表示未到达
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], -1);
        }
        Deque<int[]> dq = new ArrayDeque<>();
        dist[0][0] = health - g[0][0];
        dq.addFirst(new int[]{0, 0});
        while (!dq.isEmpty()) {
            int[] u = dq.pollFirst();
            int ux = u[0], uy = u[1];
            // 到终点即可返回
            if (ux == m - 1 && uy == n - 1) return true;
            for (int[] dir : dirs) {
                int nx = ux + dir[0], ny = uy + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                int w = g[nx][ny];
                if (dist[ux][uy] - w <= 0) continue; // 走不过去
                // 只有当新的剩余健康更大时，才“松弛”
                if (dist[ux][uy] - w > dist[nx][ny]) {
                    dist[nx][ny] = dist[ux][uy] - w;
                    if (g[nx][ny] == 0) {
                        dq.addFirst(new int[]{nx, ny});
                    } else {
                        dq.addLast(new int[]{nx, ny});
                    }
                }
            }
        }
        return false;
    }
}
