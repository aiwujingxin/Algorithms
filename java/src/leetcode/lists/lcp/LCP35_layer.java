package leetcode.lists.lcp;

import knowledge.datastructure.graph.shortestpath.impl.LayeredBFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;

/**
 * @author wujingxinit@outlook.com
 * @date 10/19/24 17:03
 */
public class LCP35_layer {

    public int electricCarPlan(int[][] paths, int cnt, int start, int end, int[] charge) {
        int n = charge.length;
        int L = cnt + 1;             // 层=电量
        int totalStates = n * L;
        // 无向图 (to, dist)
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] e : paths) {
            int u = e[0], v = e[1], d = e[2];
            adj[u].add(new int[]{v, d});
            adj[v].add(new int[]{u, d});
        }
        // 编码/解码
        java.util.function.BiFunction<Integer, Integer, Integer> enc = (city, b) -> city * L + b;
        IntFunction<int[]> dec = id -> new int[]{id / L, id % L};
        int startState = enc.apply(start, 0);
        // isTarget：到达 end 即可（任意电量）
        IntFunction<Boolean> isTarget = id -> dec.apply(id)[0] == end;
        // neighbors：充电 + 行驶
        IntFunction<List<LayeredBFS.Edge>> neighbors = id -> {
            int[] p = dec.apply(id);
            int u = p[0], b = p[1];
            List<LayeredBFS.Edge> es = new ArrayList<>();
            // 充电
            if (b < cnt) {
                es.add(new LayeredBFS.Edge(enc.apply(u, b + 1), charge[u]));
            }
            // 行驶
            for (int[] e : adj[u]) {
                int v = e[0], need = e[1];
                if (b >= need) {
                    es.add(new LayeredBFS.Edge(enc.apply(v, b - need), need)); // 距离=时间
                }
            }
            return es;
        };
        LayeredBFS solver = new LayeredBFS();
        long ans = solver.dijkstra(totalStates, startState, isTarget, neighbors);
        return (int) ans;
    }
}
