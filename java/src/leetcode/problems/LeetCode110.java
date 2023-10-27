package leetcode.problems;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/27 18:19
 */
public class LeetCode110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(getH(root.left) - getH(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getH(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getH(root.left), getH(root.right)) + 1;
    }
}
