package basic.datastructure.graph.bipartite;


import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/19 23:23
 */

class BipartiteGraph_bfs implements BipartiteGraph {

    public static void main(String[] args) {
        System.out.println(new BipartiteGraph_bfs().isBipartite(4, new int[][]{{0, 1}, {0, 3}, {1, 2}, {2, 3}}));
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
            int cur = queue.poll();
            for (int next : graph.get(cur)) {
                if (colors[next] == -1) {
                    colors[next] = 1 - colors[cur];
                    queue.add(next);
                } else if (colors[next] == colors[cur]) {
                    return false;
                }
            }
        }
        return true;
    }
}
