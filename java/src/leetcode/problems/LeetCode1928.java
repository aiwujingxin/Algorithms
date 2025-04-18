package leetcode.problems;

import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/27 19:56
 */
public class LeetCode1928 {

    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        int destination = n - 1;
        int source = 0;
        Integer[] timeHold = new Integer[n];
        Arrays.fill(timeHold, Integer.MAX_VALUE);

        List<int[]>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int src = edge[0];
            int dst = edge[1];
            int time = edge[2];
            graph[src].add(new int[]{dst, time});
            graph[dst].add(new int[]{src, time});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); //a[0] = city, a[1] = cost, a[2] = time
        pq.add(new int[]{source, passingFees[source], 0});
        timeHold[0] = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int src = cur[0];
            int fee = cur[1];
            int time = cur[2];

            if (src == destination) { // check whether destination reached ?
                return fee;
            }

            for (int[] nei : graph[src]) {

                int neiNode = nei[0];
                int neiTime = nei[1];

                if (time + neiTime > maxTime) { // we cannot exceed maxTime, return
                    continue;
                }

                if (timeHold[neiNode] > time + neiTime) {
                    timeHold[neiNode] = time + neiTime; //we found lesser time update time Array and add this node to pq..
                    pq.add(new int[]{neiNode, fee + passingFees[neiNode], timeHold[neiNode]});
                }
            }
        }
        return -1;
    }
}
