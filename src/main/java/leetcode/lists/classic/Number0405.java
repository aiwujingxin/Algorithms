package leetcode.lists.classic;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/25 17:14
 */
public class Number0405 {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValidBST(root.left, null, root) && isValidBST(root.right, root, null);

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
