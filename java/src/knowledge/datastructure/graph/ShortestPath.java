package knowledge.datastructure.graph;

import leetcode.problems.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/2 23:38
 * @description 最短路径
 * @see LeetCode743 网络延迟时间
 * @see LeetCode787
 * @see LeetCode1334_shortpath
 * @see LeetCode1514_Dijkstra
 * @see LeetCode1631
 * @see LeetCode1786
 * @see LeetCode1976
 * @see LeetCode2045
 * @see LeetCode2093_Bellman
 * @see LeetCode1928_Dijkstra
 * @see LeetCode2662
 */
public interface ShortestPath {
    int[] getShortestPath(int n, int[][] edges, int source);
}
