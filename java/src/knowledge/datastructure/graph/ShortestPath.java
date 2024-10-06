package knowledge.datastructure.graph;

import leetcode.problems.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/2 23:38
 * @description 最短路径
 * @see LeetCode743 网络延迟时间
 * @see LeetCode787
 * @see LeetCode1334_shortPath
 * @see LeetCode1514_Dijkstra
 * @see LeetCode1631
 * @see LeetCode1786
 * @see LeetCode1976
 * @see LeetCode2045
 * @see LeetCode2093_Bellman
 * @see LeetCode1928_Dijkstra
 * @see LeetCode2662
 * @see LeetCode2093_SPFA
 * @see LeetCode1514_SPFA 概率最大的路径
 */
public interface ShortestPath {
    /**
     * 返回从s到其他点的最短距离
     *
     * @param n     图中节点个数n
     * @param edges 权边, {form, to , wight}
     * @param s     源点
     */
    int[] shortestPath(int n, int[][] edges, int s);
}
