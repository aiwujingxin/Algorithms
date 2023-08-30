package leetcode.offerII;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/30 21:28
 */
public class Offer106_bfs {

    HashMap<Integer, List<Integer>> graph = new HashMap<>();

    int n;

    public boolean isBipartite(int[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            graph.put(i, new ArrayList<>());
        }
        this.n = edges.length;
        for (int i = 0; i < edges.length; i++) {
            for (int edge : edges[i]) {
                graph.get(i).add(edge);
            }
        }
        return isBipartite();
    }

    public boolean isBipartite() {
        int[] colors = new int[n];
        Arrays.fill(colors, -1);
        for (int i = 0; i < n; i++) {
            if (colors[i] == -1) {
                if (!bfs(i, colors)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean bfs(int source, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        colors[source] = 0;
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            for (int next : graph.get(currentVertex)) {
                if (colors[next] == -1) {
                    colors[next] = 1 - colors[currentVertex];
                    queue.add(next);
                } else if (colors[next] == colors[currentVertex]) {
                    return false;
                }
            }
        }
        return true;
    }
}
