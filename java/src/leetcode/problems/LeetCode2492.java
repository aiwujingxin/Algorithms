package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/1 11:37
 */
public class LeetCode2492 {

    //求从1出发到n的路径中最短的一条边，1和n可以重复走，那么意味着只要1点和n点能到达的任何点相关的边都要统计，
    //即和1在一个连通块里面的所有边中最小的一个。
    //通过dfs从1点出发，枚举所有边。
    public int minScore(int n, int[][] roads) {
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        for (int[] r : roads) {
            graph[r[0]].add(new int[]{r[1], r[2]});
            graph[r[1]].add(new int[]{r[0], r[2]});
        }
        boolean[] vis = new boolean[n + 1];
        return dfs(graph, 1, vis);
    }

    private int dfs(List<int[]>[] graph, int cur, boolean[] vis) {
        int min = Integer.MAX_VALUE;
        vis[cur] = true;
        for (int[] to : graph[cur]) {
            min = Math.min(min, to[1]);
            if (!vis[to[0]]) {
                min = Math.min(min, dfs(graph, to[0], vis));
            }
        }
        return min;
    }
}
