package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/1 16:25
 */
public class LeetCode851_TEL {
    int[] ans;
    int[] quiet;
    Map<Integer, List<Integer>> map = new HashMap<>();

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        this.quiet = quiet;
        ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = i;
        }
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        int[] degree = new int[n];
        for (int[] r : richer) {
            map.get(r[0]).add(r[1]);
            degree[r[1]]++;
        }
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) {
                dfs(i, quiet[i], i);
            }
        }
        return ans;
    }

    private void dfs(int node, int value, int pa) {
        if (value <= quiet[node] && value <= quiet[ans[node]]) {
            ans[node] = pa;
        } else {
            value = quiet[node];
            pa = node;
        }
        for (int next : map.get(node)) {
            dfs(next, value, pa);
        }
    }
}
