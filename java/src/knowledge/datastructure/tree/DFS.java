package knowledge.datastructure.tree;

import common.*;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/27 21:50
 * @see leetcode.problems.LeetCode144 前序遍历 https://leetcode.cn/problems/binary-tree-preorder-traversal/
 * @see leetcode.problems.LeetCode94 中序遍历  https://leetcode.cn/problems/binary-tree-inorder-traversal/
 * @see leetcode.problems.LeetCode145 后序遍历 https://leetcode.cn/problems/binary-tree-postorder-traversal/
 * @see leetcode.problems.LeetCode102 层序遍历 https://leetcode.cn/problems/binary-tree-level-order-traversal/
 * @see leetcode.problems.LeetCode107 二叉树的层序遍历 II  https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/
 * @see leetcode.problems.LeetCode538 538. 把二叉搜索树转换为累加树
 */
public interface DFS {

    List<Integer> DFS(TreeNode root);
}
