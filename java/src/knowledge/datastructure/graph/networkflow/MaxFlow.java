package knowledge.datastructure.graph.networkflow;

import knowledge.datastructure.graph.networkflow.impl.Dinic;
import knowledge.datastructure.graph.networkflow.impl.EdmondsKarp;
import knowledge.datastructure.graph.networkflow.impl.FordFulkerson;
import knowledge.datastructure.graph.networkflow.impl.ISAP;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author wujingxinit@outlook.com
 * @date 9/25/25 16:44
 * @description 最大流
 * <本质>
 * 最大流算法的本质是在满足容量和守恒约束的网络中，通过模拟资源流动来计算从起点到终点的最大吞吐能力，从而解决运输、分配和网络带宽等瓶颈优化问题。
 * <解决问题>
 * 在有资源限制的网络中，计算从A点到B点的资源的最优分配和最大吞吐量。
 * <性能>
 * “Dinic < FF < EK”很合理：Dinic 的分层推进与当前弧优化在单位容量二分图上非常有效；FF 在随机数据上也不差；EK 稳定但开销更高。
 * @see Dinic           分层网络 + 当前弧优化的最大流算法，本质是在分层图上分批推进阻塞流；用于求解最大流，尤其在单位容量或二分图上高效。
 * @see FordFulkerson   基于寻找任意增广路（常用 DFS）的最大流框架，本质是不断沿残量网络增广直至无路；用于最大流，简单但最坏性能可能很差。
 * @see EdmondsKarp     每次选择最短增广路以保证多项式时间；用于最大流，稳定易懂但通常比 Dinic 慢。
 * @see ISAP            ISAP 的距离标号 + gap 优化 + 当前弧组合非常高效，推进路径少、重标号精准
 */
public interface MaxFlow {

    int maxFlow(int n, int[][] edges);

    static void main(String[] args) {
        List<MaxFlow> solvers = List.of(
                new Dinic(),
                new EdmondsKarp(),
                new FordFulkerson(),
                new ISAP()
        );
        int tests = 100000;
        int nMin = 1, nMax = 80;
        double pMin = 0.02, pMax = 0.5;
        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        long[] totalTime = new long[solvers.size()];
        for (int t = 1; t <= tests; t++) {
            int n = rnd.nextInt(nMin, nMax + 1);
            double p = pMin + rnd.nextDouble() * (pMax - pMin);
            // 生成随机二分图（局部索引：左 0..n-1，右 0..n-1）
            List<int[]> ed = new ArrayList<>();
            for (int u = 0; u < n; u++) {
                for (int v = 0; v < n; v++) {
                    if (rnd.nextDouble() < p) ed.add(new int[]{u, v});
                }
            }
            int[][] edges = ed.toArray(new int[0][]);
            Integer baseline = null;
            int idx = 0;
            for (MaxFlow solver : solvers) {
                long st = System.nanoTime();
                int ans = solver.maxFlow(n, edges);
                long duration = System.nanoTime() - st;
                totalTime[idx] += duration;
                if (baseline == null) {
                    baseline = ans;
                } else if (!baseline.equals(ans)) {
                    System.out.println("Mismatch detected!");
                    System.out.println("n=" + n + ", edges=" + edges.length + ", p=" + p);
                    for (MaxFlow s2 : solvers) {
                        System.out.println("  " + s2.getClass().getSimpleName() + " -> " + s2.maxFlow(n, edges));
                    }
                    return;
                }
                idx++;
            }
            if (t % 20 == 0) {
                System.out.printf("Progress: %d/%d tests passed. Example n=%d, m=%d, p=%.3f%n",
                        t, tests, n, edges.length, p);
            }
        }
        System.out.println("All tests matched across solvers.");
        System.out.println("Average timings per test:");
        for (int i = 0; i < solvers.size(); i++) {
            double avgMs = totalTime[i] / 1e6 / tests;
            System.out.printf("  %-24s avgTime=%.3f ms%n",
                    solvers.get(i).getClass().getSimpleName(), avgMs);
        }
    }
}

