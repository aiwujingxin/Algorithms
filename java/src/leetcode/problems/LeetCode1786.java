package leetcode.problems;


import knowledge.graph.shortestpath.*;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/1 16:41
 */
public class LeetCode1786 {

    public int countRestrictedPaths(int n, int[][] edges) {
        Dijkstra dijkstra = new Dijkstra();
        int[] dist = dijkstra.getShortestPath(n + 1, edges, n);
        return (int) dfs(dijkstra.graph, 1, n, dist, new Long[n + 1]);
    }

    private long dfs(List<int[]>[] graph, int i, int n, int[] dist, Long[] cache) {
        if (i == n) {
            return 1;
        }
        if (cache[i] != null) {
            return cache[i];
        }
        long cnt = 0;
        for (int[] arr : graph[i]) {
            int next = arr[0];
            //如果相邻节点距离比当前距离小，说明是受限路径
            if (dist[next] < dist[i]) {
                cnt += dfs(graph, next, n, dist, cache);
                cnt %= 1000000007;
            }
        }
        cache[i] = cnt;
        return cnt;
    }
}
