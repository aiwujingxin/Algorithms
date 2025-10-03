package knowledge.datastructure.graph.shortestpath;

import knowledge.algorithms.search.dfsAndBfs.bfs.*;
import knowledge.datastructure.graph.shortestpath.impl.*;
import leetcode.problems.*;
import leetcode.lists.lcp.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/2 23:38
 * @description 最短路径
 * - 当且仅当边权在 {0,1} 或可通过拆边/转换变成 {0,1} 时，用 0-1 BFS，时间 O(V+E)。
 * - 否则使用 Dijkstra（优先队列），时间 O((V+E) log V)。
 * - 如果有负权但无负环，用 SPFA 或 Bellman-Ford（注意最坏复杂度）。
 * <算法>
 * @see Dijkstra            O(ElogV)            适合稀疏图，最经典的单源最短路径算法
 * @see BellmanFord         O(V * E)            有负权边，无负权回路
 * @see FloydWarshall       O(V^3)              任意权重，无负权回路
 * @see Johnson             O(V^E * V^2 logV)   适合稀疏图中的所有点对最短路径问题,包含负权边无负权回路
 * @see SPFA                O(E),最坏O(V * E)    有负权边的图，无负权回路
 * @see AStar               O(E)                启发式搜索
 * @see ZeroOneBFS          O(V + E)            适合边权为1或无权重图的最短路径
 * @see LayeredBFS          O(V + E)            分层图
 * @see TopoOrder           O(V + E)            DAG中的最短路径问题
 * <模版题>
 * @see LeetCode743             网络延迟时间
 * <单源最短路>
 * @see LeetCode1334_shortPath  阈值距离内邻居最少的城市
 * @see LeetCode1514_Dijkstra
 * @see LeetCode1786
 * @see LeetCode1976
 * @see LeetCode2045
 * @see LeetCode1514_SPFA       概率最大的路径
 * @see LeetCode1162_SPFA       地图分析
 * @see LeetCode2662
 * @see LeetCode1631            最小体力消耗路径
 * <多源最短路径>
 * @see LeetCode847
 * @see LeetCode1462_Floyd
 * @see LeetCode3015
 * <分层图最短路> 扩点 位置+状态的组合
 * @see 2953.cpp 飞行路线
 * @see LeetCode787             K 站中转内最便宜的航班
 * @see LeetCode2093_dijkstra   前往目标城市的最小费用
 * @see LeetCode1928
 * @see LeetCode864             钥匙开锁问题
 * @see LCP35
 */
public interface ShortestPath {
    /**
     * 返回从s到其他点的最短距离
     *
     * @param n     图中节点个数n
     * @param edges 权边, {from, to , wight}
     * @param s     源点
     */
    int[] shortestPath(int n, int[][] edges, int s);
}
