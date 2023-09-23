package basic.datastructure.graph;

import leetcode.problems.LeetCode743;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/2 23:38
 * @see LeetCode743 网络延迟时间
 */
public interface ShortestPath {
    int[] getShortestPath(int n, int[][] edges, int source);
}