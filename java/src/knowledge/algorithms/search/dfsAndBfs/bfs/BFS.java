package knowledge.algorithms.search.dfsAndBfs.bfs;

import knowledge.datastructure.graph.shortestpath.impl.LayeredBFS;
import knowledge.datastructure.graph.shortestpath.impl.SPFA;
import knowledge.datastructure.graph.shortestpath.impl.TopoOrder;
import knowledge.datastructure.graph.shortestpath.impl.ZeroOneBFS;
import knowledge.datastructure.graph.topological.impl.Topological_bfs;
import knowledge.datastructure.tree.traverse.LevelOrder;

/**
 * @author wujingxinit@outlook.com
 * @date 10/19/24 10:41
 * @description 广度优先搜索
 * <本质>
 * BFS及其扩展，本质上是根据问题的<边权>、<状态>与<启发>信息，选择最优的<数据结构>（队列/堆/桶）来维护一个代价非降的搜索前沿
 * 并通过<状态压缩>与<剪枝>，在隐式图中进行高效的<贪心>扩展，以求解从起点到目标的<最短路径>。
 * <优化>
 * 剪枝：通过规则砍掉不必要的分支，缩小要看的范围。
 * 引导：通过启发式或双向奔赴，让搜索更有目的地前进。
 * 压缩：通过编码优化状态的表示，让存储和计算更快更省。
 * <遍历>
 * @see LevelOrder            树的遍历
 * @see Topological_bfs       图的拓扑排序
 * @see TopoOrder             拓扑最短路  带权重的有向无环图
 * <搜索>
 * @see BiBFS                 双向BFS
 * @see AStar                 A*
 * <最短路>
 * @see LayeredBFS            分层图
 * @see ZeroOneBFS            0-1BFS  无权图最短路径
 * @see SPFA                  SPFA    带负权边的单源最短路
 * <题目>
 * @see 864
 * @see 818
 */
public interface BFS {
}
