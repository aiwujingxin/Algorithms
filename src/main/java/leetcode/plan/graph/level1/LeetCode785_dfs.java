package leetcode.plan.graph.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/22 22:53
 */
public class LeetCode785_dfs {

    //study

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];

        for (int i = 0; i < n; i++) {
            //This graph might be a disconnected graph. So check each unvisited node.
            if (colors[i] == 0 && isValidColor(graph, colors, 1, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidColor(int[][] graph, int[] colors, int color, int node) {
        if (colors[node] != 0) {
            return colors[node] != color;
        }
        colors[node] = color;
        for (int next : graph[node]) {
            if (isValidColor(graph, colors, -color, next)) {
                return true;
            }
        }
        return false;
    }
}
