package knowledge.datastructure.graph.bipartite;

import knowledge.datastructure.graph.bipartite.impl.MaxFlow;
import knowledge.datastructure.graph.bipartite.impl.HopcroftKarp;
import knowledge.datastructure.graph.bipartite.impl.Hungarian;
import knowledge.datastructure.graph.bipartite.impl.KM;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author wujingxinit@outlook.com
 * @date 9/14/25 14:52
 * @description 二分图最大匹配: 包含最多边的匹配
 * <二分图最大匹配>
 * @see Hungarian
 * @see HopcroftKarp
 * @see MaxFlow
 * <二分图最大权匹配>
 * @see KM
 */
public interface BipartiteMatch {

    int MaxMatch(int n, int[][] edges);

    static void main(String[] args) {
        // 注册三个实现（局部索引版）
        List<BipartiteMatch> solvers = List.of(new Hungarian(), new MaxFlow(), new HopcroftKarp());
        // 对拍参数
        int tests = 2000;
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
                    if (rnd.nextDouble() < p) {
                        ed.add(new int[]{u, v});
                    }
                }
            }
            int[][] edges = ed.toArray(new int[0][]);
            Integer baseline = null;
            int idx = 0;
            for (BipartiteMatch solver : solvers) {
                long st = System.nanoTime();
                int ans = solver.MaxMatch(n, edges);
                long edTime = System.nanoTime() - st;
                totalTime[idx] += edTime;
                if (baseline == null) baseline = ans;
                if (!baseline.equals(ans)) {
                    System.out.println("Mismatch detected!");
                    System.out.println("n=" + n + ", edges=" + edges.length + ", p=" + p);
                    // 打印各解结果
                    for (BipartiteMatch s2 : solvers) {
                        System.out.println("  " + s2.getClass().getSimpleName() + " -> " + s2.MaxMatch(n, edges));
                    }
                    return;
                }
                idx++;
            }
            if (t % 10 == 0) {
                System.out.printf("Progress: %d/%d tests passed. Example n=%d, m=%d, p=%.3f%n", t, tests, n, edges.length, p);
            }
        }
        System.out.println("All tests matched across solvers.");
        System.out.println("Average timings per test:");
        for (int i = 0; i < solvers.size(); i++) {
            double avgMs = totalTime[i] / 1e6 / tests;
            System.out.printf("  %-14s avgTime=%.3f ms%n", solvers.get(i).getClass().getSimpleName(), avgMs);
        }
    }
}
