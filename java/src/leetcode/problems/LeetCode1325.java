package leetcode.problems;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/20 22:34
 * @see LeetCode814
 */
public class LeetCode1325 {

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        return dfs(root, target);
    }

    private TreeNode dfs(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        root.left = dfs(root.left, target);
        root.right = dfs(root.right, target);
        if (root.left != null || root.right != null) {
            return root;
        }
        return root.val == target ? null : root;
    }
}
