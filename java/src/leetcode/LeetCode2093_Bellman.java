package leetcode;

import basic.datastructure.graph.shortestpath.Dijkstra;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/3 11:54
 */
public class LeetCode2093_Bellman {

    //https://leetcode.cn/problems/minimum-cost-to-reach-city-with-discounts/solutions/2015404/dijkstra-bellman-ford-by-lc_4fun-86j9/

    public int minimumCost(int n, int[][] highways, int discounts) {
        Dijkstra dijkstra = new Dijkstra();
        int[] dist = dijkstra.getShortestPath(n, highways, 0);
        //基于第一部分的结果利用 Bellman-Ford 算法进行折扣情况下的松弛操作,松弛操作次数为 discounts,带约束条件下的最短路径还是需要 Bellman-Ford 算法
        for (int i = 0; i < discounts; i++) {
            int[] pre = dist.clone();
            for (int[] h : highways) {
                int l = h[0];
                int r = h[1];
                int cost = h[2] / 2;
                if (pre[l] + cost < dist[r]) {
                    dist[r] = pre[l] + cost;
                }
                if (pre[r] + cost < dist[l]) {
                    dist[l] = pre[r] + cost;
                }
            }
        }
        return dist[n - 1] == Integer.MAX_VALUE / 2 ? -1 : dist[n - 1];
    }
}
