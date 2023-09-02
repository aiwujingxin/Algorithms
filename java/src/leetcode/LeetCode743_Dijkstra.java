package leetcode;

import basic.datastructure.graph.shortestpath.Dijkstra_Q;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/24 17:18
 */
public class LeetCode743_Dijkstra {

    public int networkDelayTime(int[][] times, int n, int K) {
        int[] distance = new Dijkstra_Q().getShortestPath(n, times, K);
        int result = 0;
        for (int i = 1; i < distance.length; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                // 有节点不可达，返回 -1
                return -1;
            }
            result = Math.max(result, distance[i]);
        }
        return result;
    }
}
