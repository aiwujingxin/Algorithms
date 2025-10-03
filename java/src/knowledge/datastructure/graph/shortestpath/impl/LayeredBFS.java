package knowledge.datastructure.graph.shortestpath.impl;

import leetcode.lists.lcp.LCP35_layer;
import leetcode.problems.*;

import java.util.*;
import java.util.function.IntFunction;

/**
 * @author wujingxinit@outlook.com
 * @date 9/19/25 00:32
 * @see LCP35_layer
 * @see LeetCode787_layer
 * @see LeetCode864_layer
 * @see LeetCode1293_layer
 * @see LeetCode1928_layer
 */
public class LayeredBFS {

    public record Edge(int to, long w) {
    }

    /**
     * 标准 Dijkstra，起点成本默认为 0。
     */
    public long dijkstra(int totalStates, int start, IntFunction<Boolean> isTarget, IntFunction<List<Edge>> neighbors) {
        return dijkstra(totalStates, start, 0L, isTarget, neighbors);
    }

    /**
     * 带起点成本的 Dijkstra。
     */
    public long dijkstra(int totalStates, int start, long startCost, IntFunction<Boolean> isTarget, IntFunction<List<Edge>> neighbors) {
        long[] dist = new long[totalStates];
        Arrays.fill(dist, Long.MAX_VALUE);
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        // 关键：使用传入的 startCost 初始化
        dist[start] = startCost;
        pq.offer(new long[]{start, startCost});
        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int u_id = (int) cur[0];
            long d = cur[1];
            // 使用 > dist[u_id] 更稳健，可以处理一些特殊情况
            if (d > dist[u_id]) {
                continue;
            }
            if (isTarget.apply(u_id)) {
                return d;
            }
            for (Edge e : neighbors.apply(u_id)) {
                int v_id = e.to;
                long nd = d + e.w;
                if (nd < dist[v_id]) {
                    dist[v_id] = nd;
                    pq.offer(new long[]{v_id, nd});
                }
            }
        }
        return -1;
    }

    // 通用三维编码器：(维度1, 维度2, 维度3) -> ID
    // base2 是维度2的基数（取值范围大小）
    // base3 是维度3的基数
    public static int encode(int dim1, int dim2, int dim3, int base2, int base3) {
        return ((dim1 * base2) + dim2) * base3 + dim3;
    }

    // 通用三维解码器：ID -> {维度1, 维度2, 维度3}
    public static int[] decode(int id, int base2, int base3) {
        int dim3 = id % base3;
        int tmp = id / base3;
        int dim2 = tmp % base2;
        int dim1 = tmp / base2;
        return new int[]{dim1, dim2, dim3};
    }

}
