package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/1 11:37
 * @description 即和1在一个连通块里面的所有边中最小的一个。
 */
public class LeetCode2492 {

    public int minScore(int n, int[][] roads) {
        List<int[]>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        for (int[] r : roads) {
            graph[r[0]].add(new int[]{r[1], r[2]});
            graph[r[1]].add(new int[]{r[0], r[2]});
        }
        return dfs(graph, 1, new boolean[n + 1]);
    }

    private int dfs(List<int[]>[] graph, int cur, boolean[] vis) {
        int min = Integer.MAX_VALUE;
        vis[cur] = true;
        for (int[] to : graph[cur]) {
            min = Math.min(min, to[1]);
            if (vis[to[0]]) {
                continue;
            }
            min = Math.min(min, dfs(graph, to[0], vis));
        }
        return min;
    }
}
