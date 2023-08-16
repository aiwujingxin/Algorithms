package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/13 12:36
 */
public class LeetCode1273 {

    public void dfs(int u, List<List<Integer>> edges, int[] value, int[] node_cnt) {
        for (int v : edges.get(u)) {
            dfs(v, edges, value, node_cnt);
            value[u] += value[v];
            node_cnt[u] += node_cnt[v];
        }
        if (value[u] == 0) {
            node_cnt[u] = 0;
        }
    }

    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < nodes; ++i) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < nodes; ++i) {
            if (parent[i] != -1) {
                edges.get(parent[i]).add(i);
            }
        }
        int[] node_cnt = new int[nodes];
        Arrays.fill(node_cnt, 1);
        dfs(0, edges, value, node_cnt);
        return node_cnt[0];
    }
}






