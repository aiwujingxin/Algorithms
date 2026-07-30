package knowledge.datastructure.graph.shortestpath.impl;

import knowledge.datastructure.graph.shortestpath.ShortestPath;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/29 21:37
 * @description Bellman-Ford 单源最短路精选题单与算法模板
 * <算法定位>
 * Bellman-Ford 通过“重复扫描全部边”传播最短距离,是处理负权边和检测可达负环的基础算法。
 * 与 Dijkstra 的贪心定稿不同,Bellman-Ford 不要求边权非负,节点距离可以被反复改善。
 * SPFA 与 Bellman-Ford 执行相同的松弛,区别仅在于 SPFA 用队列筛选当前可能产生更新的节点。
 * <适用条件>
 * - 有向图允许负权边,但要求从源点到目标的有效路径不受可达负环影响。
 * - 需要确定性的 O(VE) 上界,不希望承担 SPFA 在对抗数据上的不稳定表现。
 * - 路径可使用的边数/层数有明确上限,可通过限制松弛轮数直接建模。
 * - 差分约束、Johnson 重赋权等问题需要负环检测或势能函数。
 * <核心数据结构>
 * - dist[u]:当前已发现的源点到 u 的最短距离上界。
 * - edges:边集数组;每轮按顺序扫描所有有向边 (u,v,w)。
 * - backup:限制路径边数时保存上一轮距离,防止同一轮更新发生链式传播。
 * <执行链路>
 * 1. dist[source]=0,其余节点初始化为 INF。
 * 2. 重复 V-1 轮:对每条边执行 dist[v]=min(dist[v],dist[u]+w)。
 * 3. 若某一整轮没有发生更新,说明已经收敛,可以提前结束。
 * 4. 再额外扫描一轮;若仍可松弛,则存在从源点可达的负环。
 * <为什么是 V-1 轮>
 * - 不含重复节点的简单路径最多经过 V-1 条边。
 * - 若不存在可达负环,任意最短路都可去除环并转化为简单路径。
 * - 因此最多 V-1 轮后,所有有限最短距离必然已经传播完成。
 * - 第 V 轮仍能变短意味着改善路径至少含 V 条边,必然重复节点且重复部分为负环。
 * <正确性与重要性质>
 * - 松弛不变量:dist 始终对应某条已发现路径的长度,只会变小。
 * - 轮次传播:使用 backup 时,第 k 轮结束后得到“最多经过 k 条边”的最短距离。
 * - 原地更新:同一轮可能沿边顺序传播多步,只会加速收敛,不影响普通最短路最终结果。
 * - 不具备节点定稿:扫描顺序不保证距离非降序,不能首次到达目标就提前返回。
 * - 边顺序影响收敛速度,但在无可达负环时不影响最终最短距离。
 * <负环检测>
 * - 单源检测:仅当 dist[u] 有限时才允许从 u 松弛,因此只检测源点可达的负环。
 * - 全图检测:增加超级源点并向所有节点连接零权边,或将所有 dist 初始化为 0。
 * - 无向图中的负权边等价于两个方向的边,会立即形成长度为 2 的负环。
 * - 若需找出所有受负环影响的节点,可从第 V 轮仍能更新的节点继续做图遍历。
 * <原地数组与备份数组>
 * - 普通最短路:可以原地更新 dist,允许同一轮连续传播。
 * - 限制最多 K 条边:每轮必须从 backup 松弛到 dist,严格隔离新旧两层。
 * - 恰好 K 条边:新一轮应重新初始化,只从第 K-1 层转移,不能保留“不走边”的旧值。
 * <复杂度>
 * - 时间复杂度 O(VE),提前收敛时为 O(kE),其中 k<V。
 * - 空间复杂度 O(V);若保存每一轮状态或恢复路径,空间可增至 O(V^2)。
 * - 状态扩展图中设状态数为 S、转移数为 T,复杂度为 O(ST),必须先评估状态爆炸。
 * <差分约束>
 * 约束 x[v]-x[u]<=w 可转化为有向边 u→v,边权 w,再求最短路。
 * 若系统存在负环,说明约束相互矛盾;若要检测任意分量,需使用超级源点连接所有变量。
 * <算法选择决策表>
 * ▸ 无权图或所有边权相等       → BFS
 * ▸ 边权仅为 0/1              → 0-1 BFS
 * ▸ 所有边权非负              → Dijkstra
 * ▸ DAG,边权可正可负           → 拓扑序松弛
 * ▸ 存在负权边且需要稳定上界    → Bellman-Ford
 * ▸ 存在负权边且稀疏图数据温和  → 可尝试 SPFA
 * ▸ 稀疏图全源最短路           → Johnson(Bellman-Ford 重赋权 + Dijkstra)
 * <实现注意事项>
 * - 松弛前必须判断 dist[u] != INF,否则不可达节点可能通过负边产生伪距离。
 * - INF 要预留加法空间;边权或路径和较大时应使用 long 防止溢出。
 * - 第 V 轮负环检测同样只能从当前可达节点出发。
 * - 提前结束只依赖“整轮无更新”,不能因为目标节点本轮未更新就结束。
 * <I. 限制边数/层数>
 * @see leetcode.problems.LeetCode787_BellmanFord [M] K站中转内最便宜的航班 (backup 隔离每轮)
 * @see leetcode.problems.LeetCode2093_Bellman [M] 按可使用折扣次数分层松弛
 * <II. 状态维单调转移>
 * @see leetcode.problems.LeetCode1928_BellmanFord [H] 按时间维递增松弛费用状态
 * <III. 广义松弛>
 * @see leetcode.problems.LeetCode1514_BellmanFord [M] 最大概率路径 (乘法最大化)
 * <IV. 工业组合>
 * @see Johnson Bellman-Ford 计算势能后,对每个源点运行 Dijkstra
 */
public class BellmanFord implements ShortestPath {

    final static int INF = 0x3f3f3f3f;

    /**
     * 计算有向图中源点到其余节点的最短距离,并检测源点可达的负环。
     *
     * @param n     节点数量
     * @param edges 有向边,每条边格式为 {from, to, weight}
     * @param s     源点编号
     * @return 最短距离数组;检测到可达负环时返回 null
     */
    public int[] shortestPath(int n, int[][] edges, int s) {
        int[] d = new int[n];
        Arrays.fill(d, INF);
        d[s] = 0;
        for (int i = 1; i < n; i++) {
            boolean updated = false;
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                if (d[u] != INF && d[v] > d[u] + w) {
                    d[v] = d[u] + w;
                    updated = true;
                }
            }
            if (!updated) break;
        }
        // 第 V 轮仍可松弛,说明存在从源点可达的负环。
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            if (d[u] != INF && d[u] + weight < d[v]) {
                System.out.println("图中存在负权回路");
                return null;
            }
        }
        return d;
    }
}
