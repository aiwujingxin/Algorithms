package leetcode.offerII;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/30 18:33
 */
public class Offer106_dfs {

    HashMap<Integer, List<Integer>> map = new HashMap<>();

    public boolean isBipartite(int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i < graph.length; i++) {
            for (int edge : graph[i]) {
                map.get(i).add(edge);
            }
        }
        return isBipartite(graph.length);
    }

    public boolean isBipartite(int n) {
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
        for (int neighbor : map.get(v)) {
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
