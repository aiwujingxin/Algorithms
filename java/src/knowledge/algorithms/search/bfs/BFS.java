package knowledge.algorithms.search.bfs;

import knowledge.datastructure.graph.bipartite.impl.BiGraphBFS;
import knowledge.datastructure.graph.connectivity.components.ComponentsBFS;
import knowledge.datastructure.graph.connectivity.hascycle.HasCycleBFS;
import knowledge.datastructure.graph.mst.impl.Prim;
import knowledge.datastructure.graph.shortestpath.impl.*;
import knowledge.datastructure.graph.topological.impl.TopoBFS;
import knowledge.datastructure.tree.Tree;

/**
 * @author wujingxinit@outlook.com
 * @date 10/19/24 10:41
 * @description 广度优先搜索 (Breadth-First Search) 与 队列/堆 优化的图算法
 * <本质>
 * 根据问题的<边权>、<状态>、<启发>信息，选择最优的<数据结构>（队列/双端队列/优先队列）来维护一个代价非降的搜索前沿。
 * 通过<状态压缩>与<剪枝>，在<隐式图>中进行高效的<贪心>扩展，以求解从起点到目标的<最短路径>。
 * <优化>
 * 剪枝：通过规则砍掉不必要的分支，缩小要看的范围。
 * 引导：通过启发式或双向奔赴，让搜索更有目的地前进。
 * 压缩：通过编码优化状态的表示，让存储和计算更快更省。
 * <BFS-搜索 (隐式图)>
 * @see Tree.Iteration        树的BFS遍历
 * @see BiBFS                 双向BFS      (已知终点时的双向扩散)
 * @see MultiBFS              多源BFS      (多起点同时入队的扩散)
 * @see StateBFS              状压BFS      (结合位运算的状态搜索)
 * @see AStar                 A*          (基于优先队列的启发式搜索)
 * @see LimitBFS              瓶颈图/限制图 (二分答案+BFS / Min-Max路径)
 * <BFS-图论 (显式图)>
 * * <最短路>
 * @see ZeroOneBFS            0-1 BFS     (双端队列，处理边权为0/1的图)
 * @see Dijkstra              Dijkstra    (优先队列，处理非负权图)
 * @see SPFA                  SPFA        (普通队列，处理带负权边的图)
 * @see TopoOrder             拓扑最短路    (基于入度队列，针对DAG)
 * @see LayeredBFS            分层图BFS    (多维状态的最短路)
 * * <连通性>
 * @see ComponentsBFS         连通块计数   (图的连通分量划分)
 * @see HasCycleBFS           有向图判环   (基于拓扑排序或访问标记)
 * * <二分图>
 * @see BiGraphBFS            二分图判定   (基于BFS的黑白染色法)
 * * <拓扑排序>
 * @see TopoBFS               拓扑排序     (Kahn算法，基于入度为0的队列)
 * * <最小生成树>
 * @see Prim                  Prim算法
 */
public interface BFS {
}
