package knowledge.algorithms.search.dfsAndBfs;

import knowledge.algorithms.search.dfsAndBfs.impl.AStar;
import knowledge.algorithms.search.dfsAndBfs.impl.BidirectionalBFS;
import knowledge.algorithms.search.dfsAndBfs.impl.IDAStar;
import knowledge.algorithms.search.dfsAndBfs.impl.IDDFS;
import knowledge.datastructure.tree.Iteration;
import knowledge.datastructure.tree.DFS;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/23 15:31
 * @description DFSAndBFS
 * <深度优先搜索>
 * 从起始节点开始，沿着一条路径一直向下搜索(子节点)，直到无法再继续或达到目标节点。如果无法继续，则回溯到上一个节点，继续搜索其他路径。
 * @see DFS
 * <广度优先搜索>
 * 从起始节点开始，按照层级顺序逐层扩展搜索(兄弟节点)，直到找到目标节点。BFS保证在搜索树中找到的路径是最短的。
 * @see Iteration
 * @see AStar
 * @see IDAStar
 * @see BidirectionalBFS
 * @see IDDFS
 */
public interface DFSAndBFS {
}
