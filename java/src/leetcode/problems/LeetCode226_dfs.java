package leetcode.problems;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/17 20:52
 */
public class LeetCode226_dfs {

    public TreeNode invertTree(TreeNode root) {
        traverse(root);
        return root;
    }

    // 二叉树遍历函数
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        traverse(root.left);
        traverse(root.right);
    }
}
