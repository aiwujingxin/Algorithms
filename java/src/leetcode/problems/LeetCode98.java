package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/21 13:18
 */
public class LeetCode98 {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, TreeNode max, TreeNode min) {
        if (root == null) {
            return true;
        }
        if (max != null && max.val <= root.val || min != null && min.val >= root.val) {
            return false;
        }
        return isValidBST(root.left, root, min) && isValidBST(root.right, max, root);
    }
}
