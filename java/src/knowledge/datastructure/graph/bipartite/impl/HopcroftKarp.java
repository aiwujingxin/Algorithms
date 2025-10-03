package knowledge.datastructure.graph.bipartite.impl;

import knowledge.datastructure.graph.bipartite.BipartiteMatch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 9/25/25 16:40
 */

public class HopcroftKarp implements BipartiteMatch {
    private int nLeft, nRight;
    private List<Integer>[] g;
    private int[] dist;
    private int[] matchL;
    private int[] matchR;
    private static final int INF = 1 << 29;

    // 供接口调用的 MaxMatch（局部索引输入）
    @Override
    public int MaxMatch(int n, int[][] edges) {
        this.nLeft = n;
        this.nRight = n;
        // 构邻接（左->右局部索引）
        @SuppressWarnings("unchecked")
        List<Integer>[] gg = new ArrayList[n];
        for (int i = 0; i < n; i++) gg[i] = new ArrayList<>();
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            if (u < 0 || u >= n || v < 0 || v >= n) {
                throw new IllegalArgumentException("Edge endpoint out of range: " + Arrays.toString(e));
            }
            gg[u].add(v);
        }
        this.g = gg;
        this.dist = new int[nLeft];
        this.matchL = new int[nLeft];
        this.matchR = new int[nRight];
        Arrays.fill(matchL, -1);
        Arrays.fill(matchR, -1);
        return maxMatching();
    }

    // 原有 HK 过程
    public int maxMatching() {
        int matching = 0;
        while (bfs()) {
            for (int u = 0; u < nLeft; u++) {
                if (matchL[u] == -1 && dfs(u)) {
                    matching++;
                }
            }
        }
        return matching;
    }

    private boolean bfs() {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        Arrays.fill(dist, INF);
        for (int u = 0; u < nLeft; u++) {
            if (matchL[u] == -1) {
                dist[u] = 0;
                q.add(u);
            }
        }
        boolean foundAugPath = false;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : g[u]) {
                int u2 = matchR[v];
                if (u2 >= 0) {
                    if (dist[u2] == INF) {
                        dist[u2] = dist[u] + 1;
                        q.add(u2);
                    }
                } else {
                    foundAugPath = true; // 存在到自由右点的最短层次路
                }
            }
        }
        return foundAugPath;
    }

    private boolean dfs(int u) {
        for (int v : g[u]) {
            int u2 = matchR[v];
            if (u2 == -1 || (dist[u2] == dist[u] + 1 && dfs(u2))) {
                matchL[u] = v;
                matchR[v] = u;
                return true;
            }
        }
        dist[u] = Integer.MAX_VALUE; // 剪枝
        return false;
    }

    // 可选 getter
    public int[] getMatchL() {
        return matchL;
    }

    public int[] getMatchR() {
        return matchR;
    }

    @Override
    public String toString() {
        return "HopcroftKarp";
    }
}
