package knowledge.algorithms.search;

import knowledge.datastructure.tree.*;
import knowledge.algorithms.search.adv.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/23 15:31
 * @description 详细见《搜索.xmind》，《图.xmind》 和 《树.xmind》 中 深度优先搜索和广度有限搜索
 * <深度优先搜索>
 * 从起始节点开始，沿着一条路径一直向下搜索(子节点)，直到无法再继续或达到目标节点。如果无法继续，则回溯到上一个节点，继续搜索其他路径。
 * <广度优先搜索>
 * 从起始节点开始，按照层级顺序逐层扩展搜索(兄弟节点)，直到找到目标节点。BFS保证在搜索树中找到的路径是最短的。
 * @see Iteration 树的遍历
 * @see DFS 树的遍历
 * @see Backtrack 回溯算法
 * @see EightDigits 八数码问题
 */
public interface DfsAndBfs {
}
