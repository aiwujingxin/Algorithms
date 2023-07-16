package leetcode.problems;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/8 16:29
 */
public class LeetCode814 {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }
}
