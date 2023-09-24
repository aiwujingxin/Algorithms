package leetcode.lists.LCR;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/24 10:39
 */
public class LCR47 {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = pruneTree(root.left);
        TreeNode right = pruneTree(root.right);
        if (root.val == 0 && left == null && right == null) {
            return null;
        }
        root.left = left;
        root.right = right;
        return root;
    }
}
