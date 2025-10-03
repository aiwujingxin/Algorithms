package leetcode.problems;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/11 17:57
 */
public class LeetCode1123 {

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) {
            return null;
        }
        int l = d(root.left);
        int r = d(root.right);
        if (l == r) return root;
        return l > r ? lcaDeepestLeaves(root.left) : lcaDeepestLeaves(root.right);
    }

    public int d(TreeNode root) {
        if (root == null) return 0;
        return Math.max(d(root.left), d(root.right)) + 1;
    }
}
