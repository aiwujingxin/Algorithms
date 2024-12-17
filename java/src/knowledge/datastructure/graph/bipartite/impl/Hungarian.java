package knowledge.datastructure.graph.bipartite.impl;

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

public class Hungarian {

    List<Integer>[] graph;
    boolean[] vis;
    int[] match;

    public int Hungarian(int n, int[][] edges) {
        graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[1]].add(edge[0]);
            graph[edge[0]].add(edge[1]);
        }
        this.match = new int[n];    // 记录每个右部节点的匹配
        Arrays.fill(match, -1); // 初始化为-1，表示未匹配
        this.vis = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Arrays.fill(vis, false); // 每次寻找新的增广路径都重置访问状态
            if (dfs(i)) {
                ans++;
            }
        }
        return ans;
    }

    // DFS寻找增广路径
    private boolean dfs(int u) {
        for (int v : graph[u]) {
            if (!vis[v]) {
                vis[v] = true;
                // 如果v没有匹配，或者匹配的节点可以找到增广路径
                if (match[v] == -1 || dfs(match[v])) {
                    match[v] = u; // 更新匹配关系
                    return true;
                }
            }
        }
        return false;
    }
}
