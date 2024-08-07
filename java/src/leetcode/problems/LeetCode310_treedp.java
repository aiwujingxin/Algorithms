package leetcode.problems;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/28 18:10
 * @description 无根树 最长链
 */
public class LeetCode310_treedp {

    Map<Integer, List<Integer>> graph = new HashMap<>();

    // d1 stores the longest path downwards
    // d2 stores the second-longest path downwards (if d1[i] == d2[i], it means node has two longest paths)
    // up stores the path going upwards
    int[] d1, d2, p1, up;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        d1 = new int[n];
        d2 = new int[n];
        p1 = new int[n];
        up = new int[n];
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        List<Integer> res = new ArrayList<>();

        dfs1(0, -1);
        dfs2(0, -1);

        int min_height = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            // Traverse all nodes and find the minimum height
            min_height = Math.min(min_height, Math.max(d1[i], up[i]));
        }
        for (int i = 0; i < n; i++) {
            // Traverse all nodes again, if the height of the node is equal to the minimum height, add it to the answer
            if (Math.max(d1[i], up[i]) == min_height) {
                res.add(i);
            }
        }

        return res;
    }

    private void dfs1(int u, int pa) {
        d1[u] = d2[u] = 0;
        for (int ch : graph.get(u)) {
            if (ch == pa) {
                continue;
            }
            dfs1(ch, u);
            int d = d1[ch] + 1;
            if (d >= d1[u]) {
                d2[u] = d1[u];
                d1[u] = d;
                p1[u] = ch;
            } else if (d >= d2[u]) {
                d2[u] = d;
            }
        }
    }

    private void dfs2(int u, int pa) {
        for (int ch : graph.get(u)) {
            if (ch == pa) {
                continue;
            }
            if (ch == p1[u]) {
                up[ch] = Math.max(up[u], d2[u]) + 1;
            } else {
                up[ch] = Math.max(up[u], d1[u]) + 1;
            }
            dfs2(ch, u);
        }
    }
}
