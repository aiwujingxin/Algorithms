package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/16 14:44
 */
public class LeetCode110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int l = get(root.left);
        int r = get(root.right);
        if (Math.abs(l - r) > 1) {
            return false;
        }
        return isBalanced(root.right) && isBalanced(root.left);
    }

    private int get(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(get(root.left), get(root.right)) + 1;
    }
}
