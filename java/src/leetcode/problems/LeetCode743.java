package leetcode.problems;

import knowledge.datastructure.graph.shortestpath.Dijkstra;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/24 17:18
 * @link <a href="https://leetcode.cn/problems/network-delay-time/"></a>
 */
public class LeetCode743 {

    public int networkDelayTime(int[][] times, int n, int K) {
        int[] distance = new Dijkstra().shortestPath(n + 1, times, K);
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
