package knowledge.datastructure.graph.shortestpath;

import knowledge.algorithms.search.bfs.AStar;
import knowledge.datastructure.graph.shortestpath.impl.*;
import leetcode.problems.*;
import leetcode.problems.lists.lcp.LCP35_SPFA;
import leetcode.problems.lists.lcp.LCP35_state;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/2 23:38
 * @description 最短路径算法精选题单(导航索引)
 * <统一建模>
 * 1. 点(Vertex):描述一个完整状态;资源受限问题必须把资源维并入状态,不能只按位置去重。
 * 2. 边(Edge):描述一次合法决策;边权表示执行该决策新增的代价。
 * 3. 距离(Distance):从起点到状态的最小累计代价,核心操作是松弛 dist[v] = min(dist[v], dist[u] + w)。
 * 4. 目标(Goal):固定终点求 dist[target];目标状态集合则在状态首次定稿时返回。
 * <核心正确性>
 * - 最优子结构:最短路的任意前缀仍是对应端点之间的最短路。
 * - 松弛不变量:dist 始终是已发现路径的最小值,成功松弛代表找到更优路径。
 * - Dijkstra 定稿条件:边权非负时,堆中弹出的最小距离不可能再被后续路径改善。
 * - 完整状态去重:同一位置携带不同资源时后续能力不同,必须视为不同节点。
 * <分类导航>
 * I.   非负权单源最短路 — Dijkstra / 0-1 BFS / A*
 * II.  特殊图最短路     — DAG / 负权边 / 负环检测
 * III. 多源与全源最短路 — 虚拟源点 / Floyd-Warshall / Johnson
 * IV.  最短路变形       — 瓶颈路 / 概率路 / 计数 / 次短路
 * V.   状态最短路       — 位置 + 层数 / 时间 / 电量 / 掩码 / 剩余资源
 * <模板选择决策表>
 * ▸ 无权图或所有边权相等                  → BFS
 * ▸ 边权仅为 0/1                        → 0-1 BFS
 * ▸ 非负权稀疏图                         → 堆优化 Dijkstra
 * ▸ 有可靠估价函数且只求单个目标            → A*
 * ▸ DAG,边权可正可负                     → 拓扑序松弛
 * ▸ 存在负权边                           → Bellman-Ford / SPFA
 * ▸ 稠密图全源最短路,点数较小              → Floyd-Warshall
 * ▸ 稀疏图全源最短路,允许负权但无负环       → Johnson
 * ▸ 路径受次数/时间/电量/集合等资源约束     → 状态扩展 + Dijkstra
 * <I. 非负权单源最短路>
 * * <Dijkstra>
 * 条件:所有可达边权非负。
 * 策略:小顶堆维护待定状态,每次弹出当前距离最小者,再松弛其出边。
 * 本质:非负边保证路径只会越走越长,因此最小待定距离可以立即定稿。
 * 复杂度:邻接表 + 二叉堆 O((V+E) log V),空间 O(V+E)。
 * @see Dijkstra                  标准堆优化 Dijkstra
 * @see LeetCode743         [M] 网络延迟时间 (标准单源最短路)
 * @see LeetCode1334_Dijkstra [M] 阈值距离内邻居最少的城市 (枚举源点)
 * @see LeetCode2662        [M] 前往目标的最小代价 (坐标点压缩 + 特殊道路)
 * <0-1 BFS>
 * 条件:边权严格属于 {0,1}。
 * 策略:权重 0 的边从队首加入,权重 1 的边从队尾加入,维持距离非降序。
 * 本质:用双端队列替代优先队列,是 Dijkstra 在二值边权上的线性化。
 * 复杂度:O(V+E),空间 O(V)。
 * @see BFS01                     0-1 BFS 模板
 * @see LeetCode2290        [H] 到达角落需要移除障碍物的最小数目
 * * <AStar>
 * 条件:只求单目标且存在可快速计算的启发函数 h(x)。
 * 策略:按 f(x)=g(x)+h(x) 扩展;h 不高估真实剩余代价时保证最优。
 * 本质:在 Dijkstra 的确定代价 g 上叠加方向信息,减少无效搜索。
 * @see AStar                      启发式最短路模板
 * @see LeetCode1091         [M] 二进制矩阵中的最短路径
 * <II. 特殊图最短路>
 * * <DAG 最短路>
 * 条件:有向无环图,允许负权边。
 * 策略:按拓扑序处理节点,每条边只松弛一次。
 * 复杂度:O(V+E),无需优先队列。
 * @see TopoOrder                  DAG 拓扑序最短路
 * * <负权最短路>
 * 条件:允许负权边;若存在从起点可达的负环,最短距离无下界。
 * 策略:Bellman-Ford 进行 V-1 轮全边松弛;第 V 轮仍可更新则存在负环。
 * 取舍:SPFA 通过队列跳过无效松弛,随机数据常较快,但最坏仍为 O(VE),不能当作稳定线性算法。
 * @see BellmanFord                O(VE),稳定处理负权与负环检测
 * @see SPFA                       队列优化 Bellman-Ford,最坏 O(VE)
 * @see LeetCode787_BellmanFord [M] K 站中转内最便宜的航班 (限制松弛轮数)
 * <III. 多源与全源最短路>
 * * <多源最短路>
 * 策略:将所有源点以距离 0 同时入队/入堆;也可增加零权虚拟源点统一为单源问题。
 * 本质:求任意源点到其他节点的最短距离。
 * @see LeetCode1162        [M] 地图分析 (多源 BFS)
 * @see LeetCode847_state   [H] 访问所有节点的最短路径 (虚拟源点 + 状态压缩)
 * * <全源最短路>
 * Floyd 以中间点集合为 DP 阶段,适合点少、边密的图;Johnson 重赋权后对每个源点运行 Dijkstra。
 * 复杂度:Floyd O(V^3),空间 O(V^2);Johnson O(VE + V(E+V)logV)。
 * @see FloydWarshall              稠密图全源最短路
 * @see Johnson                    稀疏图全源最短路
 * @see LeetCode1462_Floyd   [M] 课程表 IV (Floyd 传递闭包)
 * @see LeetCode3015         [M] 按最短距离统计城市对
 * <IV. 最短路变形>
 * <* 边权运算变形>
 * 加法最短路只是特例;只要扩展运算满足单调性,仍可使用“最优状态优先定稿”的框架。
 * @see LeetCode1514_Dij     [M] 概率最大的路径 (乘法 + 大顶堆)
 * @see LeetCode1631         [M] 最小体力消耗路径 (最小化路径最大边)
 * * <最短路上的统计与次优>
 * @see LeetCode1786         [M] 从第一个节点出发到最后一个节点的受限路径数 (Dijkstra + DP)
 * @see LeetCode1976         [M] 到达目的地的方案数 (最短距离 + 同步计数)
 * @see LeetCode2045         [H] 到达目的地的第二短时间 (维护前两小距离)
 * <V. 状态最短路>
 * 建模:State(位置,资源1,资源2,...),每个完整状态都是扩展图中的一个节点。
 * 心法:找出影响后续决策的历史信息,把它压缩成状态维;在 neighbors 中描述资源如何变化。
 * 复杂度:设可达状态数为 S、状态转移数为 T,堆优化复杂度 O((S+T)logS)。
 * @see StateDijkstra              通用完整状态去重模板
 * @see LeetCode787_state    [M] State(city, usedEdges) K 站中转内最便宜的航班
 * @see LeetCode2093_state   [M] State(city, usedDiscounts) 前往目标城市的最低费用
 * @see LeetCode1928_state   [H] State(city, time) 规定时间内到达终点的最小花费
 * @see LeetCode864_state    [H] State(row, col, keyMask) 获取所有钥匙的最短路径
 * @see LeetCode1293_state   [H] State(row, col, remaining) 网格中的最短路径
 * @see LeetCode847_state    [H] State(node, visitedMask) 访问所有节点的最短路径
 * @see LeetCode1263_state   [H] State(boxRow, boxCol, playerRow, playerCol) 推箱子
 * @see LeetCode1654_state   [M] State(position, lastBackward) 到家的最少跳跃次数
 * @see LeetCode403_state    [H] State(stoneIndex, lastJump) 青蛙过河
 * @see LeetCode752_state    [M] State(d0, d1, d2, d3) 打开转盘锁
 * @see LeetCode773_state    [H] State(c0, c1, ..., c5) 滑动谜题
 * @see LeetCode505_state    [M] State(row, col) 迷宫 II
 * @see LCP35_state          [H] State(city, power) 电动车游城市
 * <状态图的 SPFA / Bellman-Ford>
 * 非负权状态图优先使用 Dijkstra;SPFA 可以复用同一状态建模,但最坏复杂度不稳定。
 * Bellman-Ford 只适合状态规模较小、时间/层数单调或松弛轮数有明确上界的问题,不可机械套用。
 * @see LeetCode787_SPFA          State(city, usedEdges)
 * @see LeetCode787_BellmanFord   限制航班数 = 限制 Bellman-Ford 松弛轮数
 * @see LeetCode1928_SPFA         State(city, time)
 * @see LeetCode1928_BellmanFord  时间维单调递增的 Bellman-Ford
 * @see LeetCode2093_SPFA         State(city, remainingDiscounts)
 * @see LeetCode2093_Bellman      按折扣使用次数分层松弛
 * @see LeetCode1293_SPFA         State(row, col, remaining)
 * @see LCP35_SPFA                State(city, power)
 */
public interface ShortestPath {

    /**
     * 计算源点到其余节点的最短距离。
     *
     * @param n     节点数量
     * @param edges 带权边,每条边格式为 {from, to, weight}
     * @param s     源点编号
     * @return 源点到每个节点的最短距离
     */
    int[] shortestPath(int n, int[][] edges, int s);
}
