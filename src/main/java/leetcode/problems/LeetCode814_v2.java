package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/25 23:22
 */
public class LeetCode814_v2 {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        boolean flag = traverse(root);
        if (flag) {
            return null;
        }
        return root;
    }

    public boolean traverse(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = traverse(root.left);
        boolean right = traverse(root.right);

        if (left) {
            root.left = null;
        }
        if (right) {
            root.right = null;
        }
        return left && right && root.val == 0;
    }
}
