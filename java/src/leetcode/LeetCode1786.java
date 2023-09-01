package leetcode;

import basic.datastructure.graph.shortestpath.*;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/1 16:41
 */
public class LeetCode1786 {

    public static void main(String[] args) {
        System.out.println(new LeetCode1786().countRestrictedPaths(5, new int[][]{{1, 2, 3}, {1, 3, 3}, {2, 3, 1}, {1, 4, 2}, {5, 2, 2}, {3, 5, 1}, {5, 4, 10}}));
    }

    List<int[]>[] graph;
    int N;
    final int MOD = 1000000007;

    public int countRestrictedPaths(int n, int[][] edges) {
        Dijkstra dijkstra = new Dijkstra();
        int[] dist = dijkstra.dijkstra(n, edges, n);
        this.N = n + 1;
        graph = dijkstra.getGraph();
        return (int) dfs(graph, 1, n, dist, new Long[n + 1]);
    }

    private long dfs(List<int[]>[] graph, int i, int n, int[] dist, Long[] cache) {
        if (cache[i] != null) {
            return cache[i];
        }
        if (i == n) {
            return 1;
        }
        long cnt = 0;
        for (int[] arr : graph[i]) {
            int next = arr[0];
            //如果相邻节点距离比当前距离小，说明是受限路径
            if (dist[next] < dist[i]) {
                cnt += dfs(graph, next, n, dist, cache);
                cnt %= MOD;
            }
        }
        cache[i] = cnt;
        return cnt;
    }
}
