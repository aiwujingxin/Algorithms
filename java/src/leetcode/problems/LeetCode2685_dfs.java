package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 6/21/26 15:30
 */
public class LeetCode2685_dfs {

    boolean[] vis;
    List<Integer>[] graph;

    public int countCompleteComponents(int n, int[][] edges) {
        int ans = 0;
        graph = new List[n];
        vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;
            int[] state = new int[2];
            dfs(i, state);
            int v = state[0];
            int e = state[1];
            if (e == v * (v - 1)) {
                ans++;
            }
        }
        return ans;
    }

    public void dfs(int node, int[] state) {
        if (graph[node].isEmpty()) return;
        vis[node] = true;
        state[0]++;
        state[1] += graph[node].size();
        for (int ne : graph[node]) {
            if (vis[ne]) continue;
            dfs(ne, state);
        }
    }
}
