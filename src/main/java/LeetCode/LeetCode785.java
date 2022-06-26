package LeetCode;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/25 23:01
 */
public class LeetCode785 {

    // 对于图中的任意两个节点 u 和 v，如果它们之间有一条边直接相连，那么
    //u 和 v 必须属于不同的集合。
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
