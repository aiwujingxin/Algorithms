package leetcode.lists.lcr;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/12 22:00
 */
public class LCR145 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.right, root.left);
    }

    public boolean isSymmetric(TreeNode right, TreeNode left) {
        if (right == null && left == null) {
            return true;
        }
        if (right == null || left == null || right.val != left.val) {
            return false;
        }
        return isSymmetric(right.right, left.left) && isSymmetric(right.left, left.right);
    }
}
