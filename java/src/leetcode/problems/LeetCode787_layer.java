package leetcode.problems;

import knowledge.datastructure.graph.shortestpath.impl.LayeredBFS;

import java.util.*;
import java.util.function.IntFunction;

/**
 * @author wujingxinit@outlook.com
 * @date 9/19/25 00:57
 */
public class LeetCode787_layer {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int L = k + 2; // 0..k+1
        int totalStates = n * L;
        // 图
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] f : flights) adj[f[0]].add(new int[]{f[1], f[2]});
        // 编码/解码
        java.util.function.BiFunction<Integer, Integer, Integer> enc = (city, layer) -> city * L + layer;
        IntFunction<int[]> dec = id -> new int[]{id / L, id % L};
        LayeredBFS solver = new LayeredBFS();
        int start = enc.apply(src, 0);
        long res = solver.dijkstra(
                totalStates,
                start,
                id -> dec.apply(id)[0] == dst, // 目标：任意层到达 dst
                id -> {
                    int[] p = dec.apply(id);
                    int city = p[0], layer = p[1];
                    List<LayeredBFS.Edge> es = new ArrayList<>();
                    if (layer + 1 < L) {
                        for (int[] e : adj[city]) {
                            int v = e[0], w = e[1];
                            es.add(new LayeredBFS.Edge(enc.apply(v, layer + 1), w));
                        }
                    }
                    return es;
                }
        );
        return (int) res;
    }
}
