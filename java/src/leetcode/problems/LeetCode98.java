package leetcode.problems;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/10 23:07
 */
public class LeetCode98 {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, TreeNode max, TreeNode min) {
        if (root == null) return true;
        if (max != null && root.val >= max.val) return false;
        if (min != null && root.val <= min.val) return false;
        return isValidBST(root.left, root, min) && isValidBST(root.right, max, root);
    }
}
