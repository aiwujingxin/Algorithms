package leetcode.problems;

import java.util.Deque;
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
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            colors[i] = 1;
            while (!q.isEmpty()) {
                int u = q.poll();
                for (int v : graph[u]) {
                    if (colors[v] == 0) {
                        colors[v] = -colors[u];
                        q.add(v);
                    } else if (colors[v] == colors[u]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isBipartite_dfs(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            if (colors[i] == 0 && dfs(graph, colors, 1, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int[][] graph, int[] colors, int color, int u) {
        if (colors[u] != 0) {
            return colors[u] != color;
        }
        colors[u] = color;
        for (int v : graph[u]) {
            if (dfs(graph, colors, -color, v)) {
                return true;
            }
        }
        return false;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(i);
        }
        boolean[] vs = new boolean[n];
        int[] color = new int[n];
        while (!queue.isEmpty()) {
            int u = queue.poll();
            if (!vs[u]) {
                color[u] = 1;
            }
            vs[u] = true;
            for (int v : graph[u]) {
                if (color[u] == color[v]) {
                    return false;
                }
                if (vs[v]) {
                    continue;
                }
                color[v] = -color[u];
                queue.addFirst(v);
                vs[v] = true;
            }
        }
        return true;
    }
}

