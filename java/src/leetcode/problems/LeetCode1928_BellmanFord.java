package leetcode.problems;

import java.util.Arrays;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/27 19:57
 */
public class LeetCode1928_BellmanFord {

    //https://leetcode.com/problems/minimum-cost-to-reach-destination-in-time/solutions/3659374/c-bellman-ford/

    public int minCost(int maxTime, int[][] edges, int[] fee) {
        int n = fee.length, minCost = Integer.MAX_VALUE;
        int[][] dp = new int[maxTime + 1][n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }    // initialise the dp with infinity
        dp[0][0] = fee[0];      // cost_to_reach_sourceNode = fee[sourceNode]

        for (int currTime = 0; currTime <= maxTime; currTime++) {
            for (int[] edge : edges) {                    // loop through all the edges
                int reachTime = currTime + edge[2];      // if time to reach the next node is > maxTime, then just skip this edge

                // the edges are bidirectional, so we have to handle both directions
                for (int i = 0; reachTime <= maxTime && i <= 1; i++) {
                    int fromNode = edge[i ^ 0], toNode = edge[i ^ 1];    // intelligent way to swap the fromNode and toNode
                    if (dp[currTime][fromNode] != Integer.MAX_VALUE && reachTime <= maxTime) {
                        dp[reachTime][toNode] = Math.min(dp[reachTime][toNode], dp[currTime][fromNode] + fee[toNode]);
                    }
                }
            }
        }
        for (int t = 0; t <= maxTime; t++)
            minCost = Math.min(minCost, dp[t][n - 1]); // find the minCost to reach lastNode
        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }
}
