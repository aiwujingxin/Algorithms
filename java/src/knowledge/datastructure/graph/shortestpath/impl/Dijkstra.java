package knowledge.datastructure.graph.shortestpath.impl;

import knowledge.datastructure.graph.shortestpath.ShortestPath;
import leetcode.problems.*;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/7/1 18:43
 * @description Dijkstra 非负权最短路精选题单与算法模板
 * <算法定位>
 * Dijkstra 是基于贪心定稿的单源最短路算法。
 * 它把节点分为“距离已确定”和“距离未确定”两类,每次选择当前距离最小的未确定节点定稿,
 * 再用该节点松弛所有出边,直到优先队列为空或目标节点定稿。
 * <适用条件>
 * - 所有可达边权必须非负,允许零权边。
 * - 适合非负权稀疏图、隐式状态图、网格图以及只需求单个目标的提前结束场景。
 * - 若题目还有时间、电量、次数、掩码等影响后续决策的资源,必须把它们并入完整状态。
 * - 多源问题可让所有源点以距离 0 同时入堆,等价于增加零权虚拟源点。
 * <统一建模>
 * 1. 节点/状态:描述一次决策后影响未来的全部信息。
 * 2. 边:描述一次合法转移,边权表示新增代价且必须满足 w>=0。
 * 3. dist[u]:当前已发现的源点到 u 的最短距离上界。
 * 4. 优先队列:按候选距离从小到大维护尚未定稿的节点。
 * <执行链路>
 * 1. dist[source]=0,起点以 (source,0) 入小顶堆,其余距离初始化为 INF。
 * 2. 弹出候选 (u,cost);若 cost>dist[u],说明它是旧距离产生的过期节点,直接跳过。
 * 3. 此时 u 的 dist[u] 正式定稿;若 u 是目标节点,可以立即返回。
 * 4. 枚举每条出边 (u,v,w),若 dist[u]+w<dist[v],更新并把新候选加入堆。
 * <贪心正确性>
 * - 假设 u 是当前候选距离最小的未定稿节点。
 * - 任意尚未发现的替代路径都必须先经过某个未定稿节点 x。
 * - 因为 dist[x]>=dist[u] 且后续边权非负,该路径到达 u 时不可能小于 dist[u]。
 * - 因此堆中弹出的最小有效距离不可能再被改善,u 可以安全定稿。
 * <核心性质>
 * - 弹出即定稿:仅对“未过期的堆顶”成立;入堆或首次生成时不能视为最优。
 * - 距离单调:有效弹出状态的最短距离按非降序排列。
 * - 目标提前结束:目标状态首次有效弹出时即为全局最优,无需处理剩余节点。
 * - 松弛不变量:dist 始终对应某条已发现路径,并随更优路径出现而单调减小。
 * - 不可达节点:搜索结束后仍保持 INF。
 * <重复入堆与懒删除>
 * Java PriorityQueue 不支持高效 decrease-key,因此距离变小时直接插入新的 (node,newDist)。
 * 旧候选仍留在堆中,弹出时通过 cost>dist[node] 判断并丢弃;这种方式称为懒删除。
 * 每次成功松弛最多产生一个新堆元素,不会影响正确性。
 * <复杂度>
 * - 邻接矩阵 + 线性选点:时间 O(V^2),适合稠密图。
 * - 邻接表 + 二叉堆:时间 O((V+E)logV),通常简写为 O(ElogV),空间 O(V+E)。
 * - 状态扩展图:设可达状态数为 S、转移数为 T,时间 O((S+T)logS),空间 O(S+T)。
 * - 理论上的 Fibonacci 堆可达 O(E+VlogV),竞赛与工程中通常使用二叉堆。
 * <常见变形>
 * I.   标准加法最短路 — nd=dist[u]+w,求路径总和最小。
 * II.  乘法最优路径   — probability[v]=max(probability[v],probability[u]*p),改用大顶堆。
 * III. 瓶颈最短路     — nd=max(dist[u],w),最小化路径上的最大边。
 * IV.  最短路计数     — 距离变小时覆盖方案数,距离相等时累加方案数。
 * V.   次短路         — 每个节点维护最小与次小距离,允许同一节点多次定稿。
 * VI.  状态最短路     — State(位置,资源...),在扩展图上运行普通 Dijkstra。
 * VII. Johnson 重赋权  — 先消除负边,再从每个源点执行 Dijkstra。
 * <算法选择决策表>
 * ▸ 无权图或所有边权相等       → BFS
 * ▸ 边权仅为 0/1              → 0-1 BFS
 * ▸ 非负权稀疏图              → 堆优化 Dijkstra
 * ▸ 非负权稠密图              → 朴素 Dijkstra O(V^2)
 * ▸ DAG,边权可正可负           → 拓扑序松弛
 * ▸ 存在负权边                → Bellman-Ford / SPFA
 * ▸ 单目标且有可靠启发函数      → A*
 * ▸ 稀疏图全源最短路且含负边    → Johnson
 * <实现注意事项>
 * - 负权边会破坏弹出定稿性质,不能使用 Dijkstra。
 * - 目标必须在有效弹出后判断,不能在生成邻居或首次入堆时返回。
 * - 不要在入堆时永久标记 visited;更短路径可能在节点定稿前出现。
 * - 比较器使用 Integer.compare/Long.compare,避免直接相减导致溢出。
 * - 路径和可能超过 int 时,dist 与堆中代价统一使用 long。
 * - 有向图只添加 from→to;无向图必须显式添加双向边。
 * - 状态题必须按完整状态去重,只按位置记录 dist 会错误合并不同资源状态。
 * <I. 标准非负权最短路>
 * @see LeetCode743 [M] 网络延迟时间
 * @see LeetCode1334_Dijkstra [M] 阈值距离内邻居最少的城市 (枚举源点)
 * @see LeetCode2662 [M] 前往目标的最小代价 (坐标压缩 + 特殊道路)
 * @see LeetCode3112 [M] 访问消失节点的最少时间
 * <II. 网格与隐式图>
 * @see LeetCode505_state [M] 迷宫 II (滚动距离作为边权)
 * @see LeetCode2577 [H] 在网格图中访问一个格子的最少时间
 * @see LeetCode3341 [M] 到达最后一个房间的最少时间 I
 * <III. 广义 Dijkstra>
 * @see LeetCode1514_Dij [M] 概率最大的路径 (乘法 + 大顶堆)
 * @see LeetCode1631 [M] 最小体力消耗路径 (最小化最大边)
 * @see LeetCode778 [H] 水位上升的泳池中游泳 (瓶颈最短路)
 * <IV. 计数与次短路>
 * @see LeetCode1786 [M] 受限路径数 (反向 Dijkstra + DP)
 * @see LeetCode1976 [M] 到达目的地的方案数 (最短路同步计数)
 * @see LeetCode2045 [H] 到达目的地的第二短时间
 * <V. 状态扩展 Dijkstra>
 * @see StateDijkstra 通用 State(位置,资源...) 模板
 * @see LeetCode787_state [M] State(city,usedEdges)
 * @see LeetCode2093_state [M] State(city,usedDiscounts)
 * @see LeetCode1928_state [H] State(city,time)
 * @see LeetCode864_state [H] State(row,col,keyMask)
 * @see LeetCode1293_state [H] State(row,col,remaining)
 * <VI. 全源最短路组合>
 * @see Johnson Bellman-Ford 重赋权 + 对每个源点运行 Dijkstra
 */
public class Dijkstra implements ShortestPath {

    public List<int[]>[] graph;
    final static int INF = 0x3f3f3f3f;

    /**
     * 计算无向非负权图中源点到其余节点的最短距离。
     *
     * @param n     节点数量
     * @param edges 无向边,每条边格式为 {u, v, weight}
     * @param s     源点编号
     * @return 源点到每个节点的最短距离,不可达节点保持 INF
     */
    public int[] shortestPath(int n, int[][] edges, int s) {
        this.graph = new List[n];
        Arrays.setAll(graph, i -> new ArrayList<>());
        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            graph[e[1]].add(new int[]{e[0], e[2]});
        }
        int[] d = new int[n];
        Arrays.fill(d, INF);
        d[s] = 0;
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.add(new int[]{s, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], dist = cur[1];
            // 如果弹出的节点距离已经大于当前记录的最短距离，说明是过期数据，直接跳过
            if (dist > d[u]) continue;
            for (int[] edge : graph[u]) {
                int v = edge[0];
                int w = edge[1];
                if (d[v] > d[u] + w) {
                    d[v] = d[u] + w;
                    pq.add(new int[]{v, d[v]});
                }
            }
        }
        return d;
    }
}
