package leetCode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/1 11:24
 */
public class LeetCode1466 {

    List<Integer>[] incoming, outgoing;
    HashSet<Integer> visited;
    int ans;

    public int minReorder(int n, int[][] connections) {
        ans = 0;
        incoming = new ArrayList[n];
        outgoing = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            incoming[i] = new ArrayList();
            outgoing[i] = new ArrayList();
        }
        for (int[] edge : connections) {
            incoming[edge[1]].add(edge[0]);
            outgoing[edge[0]].add(edge[1]);
        }
        visited = new HashSet<>();
        dfs(0);
        return ans;
    }

    void dfs(int v) {
        visited.add(v);
        for (int i : outgoing[v]) {
            if (!visited.contains(i)) {
                ans++;
                dfs(i);
            }
        }

        for (int i : incoming[v]) {
            if (!visited.contains(i)) {
                dfs(i);
            }
        }
    }
}
