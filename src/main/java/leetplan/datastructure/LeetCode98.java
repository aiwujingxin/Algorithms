package leetplan.datastructure;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/18 22:35
 */
public class LeetCode98 {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValidBST(root, null, null);

    }

    public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);

    }
}
