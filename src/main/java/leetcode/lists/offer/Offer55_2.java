package leetcode.lists.offer;

import common.TreeNode;

/**
 * @author jingxinwu
 * @date 2021-11-25 12:36 上午
 */
public class Offer55_2 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
