package leetcode.lists.offerII;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/25 11:26
 */
public class Offer47 {

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
