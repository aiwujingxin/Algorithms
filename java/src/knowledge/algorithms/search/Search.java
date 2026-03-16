package knowledge.algorithms.search;

import knowledge.algorithms.search.bfs.BFS;
import knowledge.algorithms.search.dfs.DFS;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/03/17 02:35
 * @description 搜索算法
 * @see DFS     深度优先搜索
 * @see BFS     广度优先搜索
 * <本质>
 * 搜索的统一思想是在适当建模的【状态空间图】中，以“前沿维护”与“剪枝/启发”为两大核心杠杆，
 * 配合最契合边权与启发信息的容器（数据结构）与展开顺序，在遍历尽可能少节点的前提下，
 * 构造出一条从起点到目标的可行解或最优解路径。
 * <核心>
 * 1. 状态空间图  状态 S、转移 T、目标 G、约束 C、代价函数 cost
 * 2. 数据结构    以队列/双端队列/桶/堆/栈等维持“代价非降”的搜索前沿，匹配边权与启发结构。
 * 3. 优化手段    可行性/最优性/对称性/记忆化/上界与边界限制；编码（二维/三维/位压）、判重（visited/dist）、邻接生成（局部性与预处理）
 */
public interface Search {
}
