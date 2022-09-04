package leetCode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/27 19:55
 */
public class LeetCode1928_dfs_dp {

    class Edge {
        int src, nbr, wt;

        public Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        List<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        for (int[] edge : edges) {
            graph[edge[0]].add(new Edge(edge[0], edge[1], edge[2]));
            graph[edge[1]].add(new Edge(edge[1], edge[0], edge[2]));
        }
        return DFS(graph, 0, maxTime, passingFees, new Integer[1001][maxTime + 1]);
    }

    private int DFS(List<Edge>[] graph, int src, int remTime, int[] passingFees, Integer[][] dp) {
        if (remTime < 0)
            return -1;
        if (dp[src][remTime] != null)
            return dp[src][remTime];
        if (src == passingFees.length - 1)
            return (dp[src][remTime] = passingFees[src]);
        int min = -1;
        for (Edge e : graph[src]) {
            int x = DFS(graph, e.nbr, remTime - e.wt, passingFees, dp);
            if (min == -1)
                min = x;
            else if (x != -1)
                min = Math.min(min, x);
        }
        if (min == -1)
            return (dp[src][remTime] = -1);
        return (dp[src][remTime] = min + passingFees[src]);
    }
}
