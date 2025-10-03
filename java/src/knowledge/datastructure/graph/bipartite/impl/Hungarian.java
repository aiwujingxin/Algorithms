package knowledge.datastructure.graph.bipartite.impl;

import knowledge.datastructure.graph.bipartite.BipartiteMatch;
import leetcode.lists.lcp.LCP04;
import leetcode.problems.LeetCode1349;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/11/5 11:10
 * @description 匈牙利算法 二分图最大匹配
 * 交替路 从一个未匹配点出发，依次经过非匹配边，匹配边，非匹配边... 形成的路径叫交替路
 * 增广路 从一个未匹配点出发，走交替路，若能到达另一个未匹配点，则这个交替路成为增广路. 非匹配边比匹配边多一条
 * 匈牙利算法: 通过不停地找增广路来增加匹配边。找不到增广路时，达到最大匹配。可以 DFS/BFS 实现
 * 时间复杂度 O(VE)
 * @see LCP04
 * @see LeetCode1349
 */
public class Hungarian implements BipartiteMatch {

    List<Integer>[] g; // 左部邻接：u -> 右部 v(0..n-1)
    boolean[] vis;     // 右部访问
    int[] match;       // 右部匹配到的左部点

    @Override
    public int MaxMatch(int n, int[][] edges) {
        g = new List[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g[u].add(v);
        }
        match = new int[n];
        Arrays.fill(match, -1);
        vis = new boolean[n];
        int ans = 0;
        for (int u = 0; u < n; u++) {
            Arrays.fill(vis, false);
            if (dfs(u)) ans++;
        }
        return ans;
    }

    private boolean dfs(int u) {
        for (int v : g[u]) {
            if (vis[v]) continue;
            vis[v] = true;
            if (match[v] == -1 || dfs(match[v])) {
                match[v] = u;
                return true;
            }
        }
        return false;
    }
}
