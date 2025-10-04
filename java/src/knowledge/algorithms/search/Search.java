package knowledge.algorithms.search;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/10 01:50
 * @description 搜索算法
 * @see knowledge.algorithms.search.dfsAndBfs.dfs      深搜（DFS/记忆化/剪枝）
 * @see knowledge.algorithms.search.dfsAndBfs.bfs      广搜（BFS/多源/双向/topo/A* ）
 * @see knowledge.algorithms.search.backtrack          回溯
 * @see knowledge.datastructure.graph.shortestpath     最短路(0-1 BFS / Dijkstra / SPFA / Bellman-Ford / 分层图）
 * <本质>
 * 搜索的统一思想，是在适当建模的状态图表示（压缩/编码）上，以“前沿维持 + 剪枝/松弛 + ”两大杠杆，配合最契合权重与启发的容器与顺序设计，
 * 在展开尽可能少的节点前提下，构造出一条从起点到目标的可行或最优解路径。
 * <核心>
 * 1. 状态空间图  状态 S、转移 T、目标 G、约束 C、代价函数 cost
 * 2. 数据结构    以队列/双端队列/桶/堆/栈等维持“代价非降”的搜索前沿，匹配边权与启发结构。
 * 3. 优化手段    可行性/最优性/对称性/记忆化/上界与边界限制；编码（二维/三维/位压）、判重（visited/dist）、邻接生成（局部性与预处理）
 */
public interface Search {
}
