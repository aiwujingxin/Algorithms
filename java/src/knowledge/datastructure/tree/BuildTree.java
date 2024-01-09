package knowledge.datastructure.tree;

import common.TreeNode;
import leetcode.problems.LeetCode105;
import leetcode.problems.LeetCode106;
import leetcode.problems.LeetCode109;
import leetcode.problems.LeetCode889;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/7 13:03
 * @see LeetCode106 从中序与后序遍历序列构造二叉树
 * @see LeetCode105 从前序与中序遍历序列构造二叉树
 * @see LeetCode889 根据前序和后序遍历构造二叉树
 * @see LeetCode109 有序链表转换二叉搜索树
 */
public interface BuildTree {

    TreeNode buildTree(int[] a, int[] b);
}
