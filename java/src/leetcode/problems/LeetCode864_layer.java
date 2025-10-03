package leetcode.problems;

import knowledge.datastructure.graph.shortestpath.impl.LayeredBFS;

import java.util.*;
import java.util.function.IntFunction;

/**
 * @author wujingxinit@outlook.com
 * @date 10/19/24 16:36
 */
public class LeetCode864_layer {

    // 编码/解码为普通方法（避免 TriFunction）
    private int enc(int x, int y, int mask, int m, int L) {
        return (x * m + y) * L + mask;
    }

    private int[] dec(int id, int m, int L) {
        int mask = id % L;
        int tmp = id / L;
        int y = tmp % m;
        int x = tmp / m;
        return new int[]{x, y, mask};
    }

    public int shortestPathAllKeys(String[] grid) {
        int n = grid.length, m = grid[0].length();
        char[][] g = new char[n][m];
        int sx = -1, sy = -1, K = 0;
        for (int i = 0; i < n; i++) {
            g[i] = grid[i].toCharArray();
            for (int j = 0; j < m; j++) {
                char c = g[i][j];
                if (c == '@') {
                    sx = i;
                    sy = j;
                }
                if (c >= 'a' && c <= 'f') K = Math.max(K, c - 'a' + 1);
            }
        }
        int L = 1 << K; // mask 层
        int totalStates = n * m * L;
        int start = enc(sx, sy, 0, m, L);
        int fullMask = L - 1;
        // 目标：收集齐所有钥匙
        IntFunction<Boolean> isTarget = id -> dec(id, m, L)[2] == fullMask;
        // 四方向移动（单位权 = 1），处理墙/门/钥匙
        int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
        IntFunction<List<LayeredBFS.Edge>> neighbors = id -> {
            int[] p = dec(id, m, L);
            int x = p[0], y = p[1], mask = p[2];
            List<LayeredBFS.Edge> es = new ArrayList<>();
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir], ny = y + dy[dir];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                char c = g[nx][ny];
                if (c == '#') continue; // 墙
                if (c >= 'A' && c <= 'F') {
                    int need = c - 'A';
                    if ((mask & (1 << need)) == 0) continue; // 没钥匙，过不去
                }
                int nmask = mask;
                if (c >= 'a' && c <= 'f') {
                    nmask |= (1 << (c - 'a'));
                }
                int nid = enc(nx, ny, nmask, m, L);
                es.add(new LayeredBFS.Edge(nid, 1)); // 单位步长
            }
            return es;
        };
        LayeredBFS solver = new LayeredBFS();
        long ans = solver.dijkstra(totalStates, start, isTarget, neighbors);
        return (int) ans;
    }
}
