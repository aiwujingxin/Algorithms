package knowledge.algorithms.search.dfsAndBfs.dfs;

import knowledge.algorithms.dp.memoization.DFSMemo;
import knowledge.datastructure.graph.topological.impl.Topological_dfs;

/**
 * @author wujingxinit@outlook.com
 * @date 10/19/24 10:44
 * @description 深度优先搜索
 * <本质>
 * 利用递归或栈结构，通过“探索-回溯”的机制，系统性地枚举状态空间中的所有路径，以求解路径相关问题或进行连通性探索。
 * <优化>
 * 剪枝：通过可行性、最优性和记忆化规则，在进入递归前“砍掉”无效的子树。
 * 排序：通过启发式地安排分支探索顺序，争取尽早找到好解，从而赋能更强的最优性剪枝。
 * 加深：通过迭代加深的方式，融合DFS的空间优势与BFS的最短路径保证。
 * <遍历>
 * @see knowledge.datastructure.tree.DFS            树的遍历
 * <搜索>
 * @see IDDFS                                       迭代加深
 * @see IDAStar                                     IDA*
 * <图>
 * @see knowledge.datastructure.graph.connectivity  连通性
 * @see Topological_dfs                             拓扑排序
 * <DP>
 * @see knowledge.algorithms.dp.treedp.TreeDP       树形DP
 * @see DFSMemo                                     记忆化搜索
 */
public interface DFS {
}
