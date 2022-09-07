package codeTop.ms;

import common.TreeNode;

/**
 * @author jingxinwu
 * @date 2022-02-16 3:11 PM
 */
public class LeetCode98 {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {

        if (root == null) {
            return true;
        }

        //fix 注意比较符号
        if (min != null && root.val <= min.val) {
            return false;

        }
        //fix 注意比较符号
        if (max != null && root.val >= max.val) {
            return false;

        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);

    }

}
