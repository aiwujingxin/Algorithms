package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/13 13:43
 */
public class LeetCode1519 {

    int[] ans;
    char[] labels;
    int n;
    boolean[] visited;

    Map<Integer, List<Integer>> graph = new HashMap<>();

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        this.n = n;
        ans = new int[n];
        visited = new boolean[n];
        this.labels = labels.toCharArray();
        build(edges);
        dfs(0);
        return ans;
    }

    private Map<Character, Integer> dfs(int node) {
        char c = labels[node];
        Map<Character, Integer> cntMap = new HashMap<>();
        if (graph.get(node).isEmpty()) {
            ans[node] = 1;
            cntMap.put(c, 1);
            return cntMap;
        }
        if (visited[node]) {
            return cntMap;
        }
        visited[node] = true;
        for (int child : graph.get(node)) {
            Map<Character, Integer> childMap = dfs(child);
            for (Map.Entry<Character, Integer> entry : childMap.entrySet()) {
                cntMap.put(entry.getKey(), cntMap.getOrDefault(entry.getKey(), 0) + entry.getValue());
            }
        }
        cntMap.put(c, cntMap.getOrDefault(c, 0) + 1);
        ans[node] = cntMap.get(c);
        return cntMap;
    }

    private void build(int[][] edges) {
        for (int i = 0; i < n; i++) {
            graph.putIfAbsent(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
    }
}
