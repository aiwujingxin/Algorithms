package leetcode.problems;


import knowledge.datastructure.graph.shortestpath.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/24 17:18
 */
public class LeetCode743 {

    public int networkDelayTime(int[][] times, int n, int K) {
        int[] distance = new Dijkstra().getShortestPath(n + 1, times, K);
        int result = 0;
        for (int i = 1; i < distance.length; i++) {
            if (distance[i] == 0x3f3f3f3f) {
                return -1;
            }
            result = Math.max(result, distance[i]);
        }
        return result;
    }
}
