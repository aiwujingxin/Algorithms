package basic.datastructure.graph.bipartite;

import basic.datastructure.graph.BipartiteGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/19 23:31
 */
public class BipartiteGraph_dfs implements BipartiteGraph {

    public static void main(String[] args) {
        System.out.println(new BipartiteGraph_dfs().isBipartite(4, new int[][]{{0, 1}, {0, 3}, {1, 2}, {2, 3}}));
    }

    HashMap<Integer, List<Integer>> graph = new HashMap<>();

    public boolean isBipartite(int n, int[][] edges) {
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[1]).add(edge[0]);
        }
        int[] colors = new int[n];
        Arrays.fill(colors, -1);
        for (int i = 0; i < n; i++) {
            if (colors[i] == -1) {
                if (!dfs(i, colors, 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int v, int[] colors, int color) {
        colors[v] = color;
        for (int neighbor : graph.get(v)) {
            if (colors[neighbor] == color) {
                return false;
            }
            if (colors[neighbor] == -1 && !dfs(neighbor, colors, 1 - color)) {
                return false;
            }
        }
        return true;
    }
}
