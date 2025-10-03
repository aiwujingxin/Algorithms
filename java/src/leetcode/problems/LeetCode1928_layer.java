package leetcode.problems;

import knowledge.datastructure.graph.shortestpath.impl.LayeredBFS;

import java.util.*;
import java.util.function.IntFunction;

/**
 * @author wujingxinit@outlook.com
 * @date 9/19/25 01:01
 */
public class LeetCode1928_layer {

    public int minCost(int maxTime, int[][] edges, int[] fee) {
        int n = fee.length;
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] e : edges) {
            int u = e[0], v = e[1], t = e[2];
            adj[u].add(new int[]{v, t});
            adj[v].add(new int[]{u, t});
        }
        // 1. 定义状态空间和编码参数
        // 维度1: city (0 to n-1)
        // 维度2: time (0 to maxTime)
        int timeBase = maxTime + 1; // time 维度的基数
        int virtualBase = 1;        // 虚拟的第三维，基数为 1
        int totalStates = n * timeBase * virtualBase;
        // 2. 定义 isTarget 函数
        IntFunction<Boolean> isTarget = id -> {
            int[] decoded = LayeredBFS.decode(id, timeBase, virtualBase);
            int city = decoded[0];
            return city == n - 1;
        };
        // 3. 定义 neighbors 函数
        IntFunction<List<LayeredBFS.Edge>> neighbors = id -> {
            // 解码当前状态
            int[] decoded = LayeredBFS.decode(id, timeBase, virtualBase);
            int currentCity = decoded[0];
            int currentTime = decoded[1];
            List<LayeredBFS.Edge> es = new ArrayList<>();
            for (int[] e : adj[currentCity]) {
                int nextCity = e[0];
                int timeCost = e[1];
                int nextTime = currentTime + timeCost;
                if (nextTime < timeBase) { // 检查时间是否超限
                    // 编码新状态 (city, time, 0)
                    int nextId = LayeredBFS.encode(nextCity, nextTime, 0, timeBase, virtualBase);
                    es.add(new LayeredBFS.Edge(nextId, fee[nextCity]));
                }
            }
            return es;
        };
        // 4. 创建 solver 实例并调用
        LayeredBFS solver = new LayeredBFS();
        // 编码起点状态 (city=0, time=0, virtual=0)
        int startId = LayeredBFS.encode(0, 0, 0, timeBase, virtualBase);
        // 调用带 startCost 的版本
        long ans = solver.dijkstra(totalStates, startId, fee[0], isTarget, neighbors);
        return (int) ans;
    }
}
