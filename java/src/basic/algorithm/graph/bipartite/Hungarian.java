package basic.algorithm.graph.bipartite;

import java.util.Arrays;


/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/20 00:10
 * {@link leetcode.lists.lcp.LCP04}
 * {@link leetcode.problems.LeetCode1349}
 */

public class Hungarian {

    private int[][] graph;
    private int[] match;
    private boolean[] visited;

    public static void main(String[] args) {
        int[][] graph = {
                {1, 0, 1, 0},
                {1, 1, 0, 0},
                {0, 1, 0, 1},
                {0, 0, 1, 0}
        };
        Hungarian hungarian = new Hungarian();
        int maxMatching = hungarian.maxMatching(graph);
        System.out.println("Maximum Matching: " + maxMatching);
    }

    public int maxMatching(int[][] graph) {
        this.graph = graph;
        int n = graph.length;
        int m = graph[0].length;
        match = new int[m];
        Arrays.fill(match, -1);
        int count = 0;
        for (int i = 0; i < n; i++) {
            visited = new boolean[m];
            if (dfs(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean dfs(int i) {
        int n = graph.length;
        int m = graph[0].length;
        for (int v = 0; v < m; v++) {
            if (graph[i][v] == 1 && !visited[v]) {
                visited[v] = true;
                if (match[v] == -1 || dfs(match[v])) {
                    match[v] = i;
                    return true;
                }
            }
        }
        return false;
    }
}
