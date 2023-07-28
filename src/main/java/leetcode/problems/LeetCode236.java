package leetcode.problems;

import common.*;

/**
 * @author jingxinwu
 * @date 2021-08-25 1:44 上午
 * {@link LeetCode1080}
 * {@link LeetCode865}
 */
public class LeetCode236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
