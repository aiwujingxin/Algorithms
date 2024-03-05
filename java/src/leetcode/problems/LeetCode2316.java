package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/5 10:49
 */
public class LeetCode2316 {

    List<Integer>[] graph;

    public long countPairs(int n, int[][] edges) {
        graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        long sum = 0;
        HashSet<Integer> set = new HashSet<>();
        long res = 0;

        for (int i = 0; i < n; i++) {
            long cnt = dfs(i, set);
            if (cnt == 0) {
                continue;
            }
            res += sum * cnt;
            sum += cnt;
        }
        return res;
    }

    private long dfs(int u, HashSet<Integer> set) {
        if (set.contains(u)) {
            return 0;
        }
        set.add(u);
        long cnt = 1;
        for (int ne : graph[u]) {
            cnt += dfs(ne, set);
        }
        return cnt;
    }
}
