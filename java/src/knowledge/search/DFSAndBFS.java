package knowledge.search;


import knowledge.datastructure.tree.DFS;
import knowledge.datastructure.tree.Iteration;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/27 00:35
 * @description 详细见《3搜索.xmind》，《图.xmind》 和 《4树.xmind》 中 深度优先搜索和广度有限搜索部分
 * <深度优先搜索>
 * 从起始节点开始，沿着一条路径一直向下搜索，直到无法再继续或达到目标节点。如果无法继续，则回溯到上一个节点，继续搜索其他路径。
 * <广度优先搜索>
 * 从起始节点开始，按照层级顺序逐层扩展搜索，直到找到目标节点。BFS保证在搜索树中找到的路径是最短的。
 * @see Iteration
 * @see DFS
 * @see leetcode.problems.LeetCode144 前序遍历 https://leetcode.cn/problems/binary-tree-preorder-traversal/
 * @see leetcode.problems.LeetCode94 中序遍历  https://leetcode.cn/problems/binary-tree-inorder-traversal/
 * @see leetcode.problems.LeetCode145 后序遍历 https://leetcode.cn/problems/binary-tree-postorder-traversal/
 * @see leetcode.problems.LeetCode102 后序遍历 https://leetcode.cn/problems/binary-tree-level-order-traversal/
 * @see leetcode.problems.LeetCode107 二叉树的层序遍历 II  https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/
 * @see leetcode.problems.LeetCode538 538. 把二叉搜索树转换为累加树
 */
public interface DFSAndBFS {
}
