package leetcode.lists.topinterview;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/23 17:50
 */
public class LeetCode98 {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        //fix null null
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null) {
            if (root.val <= min.val) {
                return false;
            }
        }
        if (max != null) {
            if (root.val >= max.val) {
                return false;
            }
        }
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
}
