package knowledge.datastructure.graph.bipartite.impl;

import leetcode.lists.lcp.LCP04;
import leetcode.problems.LeetCode1349;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/20 00:10
 * @description 二分图最大匹配 匈牙利算法(增光路算法)
 * 时间复杂度 O(VE)
 * @see LCP04
 * @see LeetCode1349
 */

public class Hungarian {

    List<Integer>[] graph;
    boolean[] visited;
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
        this.visited = new boolean[n];
        int ans = 0;
        for (int u = 0; u < graph.length; u++) {
            Arrays.fill(visited, false); // 每次寻找新的增广路径都重置访问状态
            if (dfs(u)) {
                ans++;
            }
        }
        return ans;
    }

    // DFS寻找增广路径
    private boolean dfs(int u) {
        for (int v : graph[u]) {
            if (!visited[v]) {
                visited[v] = true;
                // 如果v没有匹配，或者匹配的节点可以找到增广路径，则更新匹配关系
                if (match[v] == -1 || dfs(match[v])) {
                    match[v] = u; // 配成对
                    return true;
                }
            }
        }
        return false;
    }
}
