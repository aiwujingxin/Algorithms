package basic.datastructure.tree;

import common.TreeNode;

import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/7 11:44
 * @see leetcode.problems.LeetCode144 前序遍历 https://leetcode.cn/problems/binary-tree-preorder-traversal/
 * @see leetcode.problems.LeetCode94 中序遍历  https://leetcode.cn/problems/binary-tree-inorder-traversal/
 * @see leetcode.problems.LeetCode145 后序遍历 https://leetcode.cn/problems/binary-tree-postorder-traversal/
 * @see leetcode.problems.LeetCode102 后序遍历 https://leetcode.cn/problems/binary-tree-level-order-traversal/
 * @see leetcode.problems.LeetCode107 二叉树的层序遍历 II  https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/
 */
public interface Traverse {

    List<Integer> DFS(TreeNode root);

    List<Integer> Iteration(TreeNode root);
}
