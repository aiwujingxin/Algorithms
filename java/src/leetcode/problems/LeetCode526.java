package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

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

    private void backtrack(int index, int n) {
        if (index == n + 1) {
            res++;
            return;
        }
        if (graph[index].isEmpty()) {
            return;
        }
        for (int i = 0; i < graph[index].size(); i++) {
            if (visited[graph[index].get(i)]) {
                continue;
            }
            visited[graph[index].get(i)] = true;
            backtrack(index + 1, n);
            visited[graph[index].get(i)] = false;
        }
    }
}
