package leetcode.problems;

import knowledge.datastructure.graph.shortestpath.impl.LayeredBFS;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntFunction;

/**
 * @author wujingxinit@outlook.com
 * @date 9/19/25 01:10
 */
public class LeetCode1293_layer {

    public int shortestPath(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        if (n == 1 && m == 1) return 0;
        int L = k + 1;                 // 层 = 已消除障碍数 used，0..k
        int totalStates = n * m * L;
        int start = LayeredBFS.encode(0, 0, 0, m, L);
        int tx = n - 1, ty = m - 1;
        // 目标：到达 (tx, ty) 任意 used 层
        IntFunction<Boolean> isTarget = id -> {
            int[] p = LayeredBFS.decode(id, m, L);
            return p[0] == tx && p[1] == ty;
        };
        // 邻接：四方向移动，权重恒 1；遇障碍 used+1，否则 used 不变
        int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
        IntFunction<List<LayeredBFS.Edge>> neighbors = id -> {
            int[] p = LayeredBFS.decode(id, m, L);
            int x = p[0], y = p[1], used = p[2];
            List<LayeredBFS.Edge> es = new ArrayList<>(4);
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir], ny = y + dy[dir];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                int nused = used + (grid[nx][ny] == 1 ? 1 : 0);
                if (nused <= k) {
                    int nid = LayeredBFS.encode(nx, ny, nused, m, L);
                    es.add(new LayeredBFS.Edge(nid, 1)); // 单位步长
                }
            }
            return es;
        };
        LayeredBFS solver = new LayeredBFS();
        long ans = solver.dijkstra(totalStates, start, isTarget, neighbors);
        return (int) ans;
    }
}
