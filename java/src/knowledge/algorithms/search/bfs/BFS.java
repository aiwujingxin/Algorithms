package knowledge.algorithms.search.bfs;

import knowledge.algorithms.search.problems.EightPuzzle_bfs;
import knowledge.datastructure.graph.bipartite.impl.BiGraphBFS;
import knowledge.datastructure.graph.connectivity.components.ComponentsBFS;
import knowledge.datastructure.graph.connectivity.hascycle.HasCycleBFS;
import knowledge.datastructure.graph.mst.impl.Prim;
import knowledge.datastructure.graph.shortestpath.impl.*;
import knowledge.datastructure.graph.topological.impl.TopoBFS;
import knowledge.datastructure.tree.Tree;
import leetcode.problems.*;

/**
 * @author wujingxinit@outlook.com
 * @date 10/19/24 10:41
 * @description 广度优先搜索（BFS）精选模板与题型导航
 * <解题识别>
 * 出现以下信号优先把问题建模为 BFS:
 * 1. 求无权图 / 等权图的最少步数、最少操作次数或最近距离。
 * 2. 从一个状态经过合法操作变成另一个状态——题面没有图，但存在隐式状态图。
 * 3. 多个起点同时扩散、求每个位置到最近源点的距离。
 * 4. 状态包含钥匙、访问集合、剩余次数等会影响未来选择的附加信息。
 * <本质>
 * BFS = 状态图 + 搜索前沿 + 去重规则。
 * 普通队列按层维护“距离非降”的前沿，因此无权图中状态第一次入队时就得到最短距离。
 * 边权变化时，本质框架不变，只需更换维护前沿的容器与松弛规则。
 * <三大优化>
 * - 剪枝:visited、合法性判断、最优代价表，砍掉重复或不可能更优的状态。
 * - 引导:双向 BFS 从两端相遇，A* 用启发函数把前沿引向目标。
 * - 压缩:坐标编码、位掩码、分层图，把复合状态压成可高效去重的节点。
 * <容器选择>
 * @see BFS01       边权仅 0/1 → 双端队列，O(V + E)
 * @see Dijkstra    非负边权 → 小顶堆，O((V + E) log V)
 * @see TopoOrder   DAG → 拓扑序松弛，O(V + E)，允许负边
 * @see SPFA        含负边无负环 → 队列松弛，最坏 O(VE)
 * <I. 标准 BFS / 隐式图最短步数>
 * 建模:节点是位置或状态，一次合法操作是一条权重为 1 的边。
 * 本质:队列完整处理完第 d 层后才会进入第 d+1 层，故第一次到达就是最短。
 * @see Tree.Iteration    树的层序遍历
 * @see EightPuzzle_bfs   八数码状态搜索
 * @see LeetCode1091      [M] 二进制矩阵中的最短路径
 * @see LeetCode1926      [M] 迷宫中离入口最近的出口
 * @see LeetCode1306      [M] 跳跃游戏 III
 * @see LeetCode1654      [M] 到家的最少跳跃次数
 * <II. 双向 BFS>
 * 建模:起点和终点各维护一个距离表，每轮扩展较小前沿，交汇时合并距离。
 * 本质:将深度 d 的指数搜索拆成两个约 d/2 深度的搜索。
 * @see BiBFS             双向 BFS 模板
 * @see LeetCode127_2bfs  [H] 单词接龙
 * @see LeetCode433_2bfs  [M] 最小基因变化
 * @see LeetCode752_2bfs  [M] 打开转盘锁
 * @see LeetCode773_2bfs  [H] 滑动谜题
 * <III. 多源 BFS>
 * 建模:所有源点距离设为 0 并同时入队，等价于增加一个连接全部源点的超级源点。
 * 本质:不同源点的波前竞争同一格子，第一次占领者就是最近源点。
 * @see MultiBFS          多源网格 BFS 模板
 * @see LeetCode542       [M] 01 矩阵
 * @see LeetCode994       [M] 腐烂的橘子
 * @see LeetCode1162      [M] 地图分析
 * @see LeetCode1765      [M] 地图中的最高点
 * <IV. 状态压缩 / 分层图 BFS>
 * 建模:当附加资源影响未来转移时，将 (位置, 资源状态) 作为新节点，不能只按位置去重。
 * 本质:把原图提升为“位置图 × 状态图”的乘积图，再在扩展后的图上求最短路。
 * @see StateBFS          位掩码状态 BFS 模板
 * @see LayeredBFS        分层图编码与带权搜索
 * @see LeetCode847       [H] 访问所有节点的最短路径
 * @see LeetCode864       [H] 获取所有钥匙的最短路径
 * @see LeetCode1293      [H] 网格中的最短路径
 * @see LeetCode787       [M] K 站中转内最便宜的航班
 * <V. A* 启发式搜索>
 * 建模:f = g + h，g 为已走代价，h 为到目标的乐观估价，优先扩展 f 最小状态。
 * 本质:在保持最优性的前提下，用问题知识减少与目标无关的扩展；h=0 时退化为 Dijkstra。
 * @see AStar                 A* 泛型模板与常见启发函数
 * @see LeetCode752_astar     [M] 打开转盘锁
 * @see LeetCode127_star      [H] 单词接龙
 * <VI. 二分答案 + 限制 BFS>
 * 建模:把“最小化最大代价”转成“给定 limit 能否连通”，利用可行性的单调性二分答案。
 * 本质:优化问题降维成判定问题，BFS 只负责阈值下的可达性。
 * @see LimitBFS          限制图 / 瓶颈图模板
 * @see LeetCode778       [H] 水位上升的泳池中游泳
 * @see LeetCode1631      [M] 最小体力消耗路径
 * <VII. 带权搜索前沿>
 * 建模:边权决定容器；0/1 用双端队列，非负权用堆，DAG 用拓扑序。
 * 本质:所有变体都在维护“下一个应被确定的最小代价状态”，区别只是维持代价顺序的机制。
 * @see BFS01             0-1 BFS
 * @see Dijkstra          非负权最短路
 * @see TopoOrder         DAG 最短路
 * @see Prim              最小生成树的堆前沿
 * <VIII. 图结构分析>
 * 建模:BFS 不只求距离，还可沿边完成染色、分量标记和依赖消除。
 * 本质:一次扩散会完整覆盖同一连通分量；层级奇偶给出二分图颜色；入度归零驱动拓扑序。
 * @see ComponentsBFS     连通块计数
 * @see BiGraphBFS        二分图黑白染色
 * @see HasCycleBFS       有向图判环
 * @see TopoBFS           Kahn 拓扑排序
 * @see LeetCode547_bfs   [M] 省份数量
 * @see LeetCode785       [M] 判断二分图
 * @see LeetCode207       [M] 课程表
 * @see LeetCode210       [M] 课程表 II
 */
public interface BFS {
}
