package leetcode.problems;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/25 00:36
 */
public class LeetCode897 {

    private TreeNode cur;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode newRoot = new TreeNode();
        cur = newRoot;
        dfs(root);
        return newRoot.right;
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        node.left = null;
        cur.right = node;
        cur = cur.right;
        dfs(node.right);
    }
}
