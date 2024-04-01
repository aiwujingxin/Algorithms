package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/22 16:22
 */
public class LeetCode526 {

    int res;

    List<Integer>[] graph;

    boolean[] visited;

    public int countArrangement(int n) {
        graph = new List[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i % j == 0 || j % i == 0) {
                    graph[i].add(j);
                }
            }
        }
        backtrack(1, n);
        return res;
    }

    private void backtrack(int u, int n) {
        if (u == n + 1) {
            res++;
            return;
        }
        for (int v : graph[u]) {
            if (visited[v]) {
                continue;
            }
            visited[v] = true;
            backtrack(u + 1, n);
            visited[v] = false;
        }
    }
}
