package knowledge.algorithms.search.dfsAndBfs;

import knowledge.algorithms.search.dfsAndBfs.bfs.AStar;
import knowledge.algorithms.search.dfsAndBfs.bfs.BiBFS;
import knowledge.algorithms.search.dfsAndBfs.bfs.MultiBFS;
import knowledge.algorithms.search.dfsAndBfs.bfs.StateBFS;
import knowledge.algorithms.search.dfsAndBfs.dfs.IDAStar;
import knowledge.datastructure.graph.bipartite.impl.BiGraph_bfs;
import knowledge.datastructure.graph.connectivity.hascycle.HasCycle_bfs;
import knowledge.datastructure.graph.shortestpath.impl.*;
import knowledge.datastructure.graph.topological.impl.Topo_bfs;
import knowledge.datastructure.tree.Tree;

/**
 * @author wujingxinit@outlook.com
 * @date 10/19/24 10:41
 * @description 广度优先搜索
 * <本质>
 * 根据问题的<边权>、<状态>、<启发>信息，选择最优的<数据结构>（队列/堆/桶）来维护一个代价非降的搜索前沿
 * 通过<状态压缩>与<剪枝>，在<隐式图>中进行高效的<贪心>扩展，以求解从起点到目标的<最短路径>。
 * <优化>
 * 剪枝：通过规则砍掉不必要的分支，缩小要看的范围。
 * 引导：通过启发式或双向奔赴，让搜索更有目的地前进。
 * 压缩：通过编码优化状态的表示，让存储和计算更快更省。
 * <遍历>
 * @see Tree.Iteration        BFS遍历
 * @see Topo_bfs              拓扑排序
 * @see MultiBFS              多源BFS
 * <搜索>
 * @see AStar                 A*
 * @see BiBFS                 双向BFS
 * @see IDAStar               IDA*
 * @see StateBFS              状压BFS
 * <最短路>
 * @see Dijkstra              Dijkstra
 * @see TopoOrder             拓扑最短路   带权重的有向无环图
 * @see LayeredBFS            分层图
 * @see ZeroOneBFS            0-1BFS     无权图最短路径
 * @see SPFA                  SPFA       带负权边的单源最短路
 * <图>
 * @see BiGraph_bfs           二分图
 * @see HasCycle_bfs          有向图判环
 */
public interface BFS {
}
