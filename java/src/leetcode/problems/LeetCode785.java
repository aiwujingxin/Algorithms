package leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/25 23:10
 */
public class LeetCode785 {

    public boolean isBipartite_bfs(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            if (colors[i] != 0) {
                continue;
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            colors[i] = 1;   // Blue: 1; Red: -1.
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int next : graph[cur]) {
                    if (colors[next] == 0) {          // If this node hasn't been colored;
                        colors[next] = -colors[cur];  // Color it with a different color;
                        queue.offer(next);
                    } else if (colors[next] != -colors[cur]) {   // If it is colored and its color is different, return false;
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // 对于图中的任意两个节点 u 和 v，如果它们之间有一条边直接相连，那么
    //u 和 v 必须属于不同的集合。
    public boolean isBipartite_dfs(int[][] graph) {
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

