package codeTop.ms;

import common.TreeNode;

/**
 * @author jingxinwu
 * @date 2022-02-16 6:58 PM
 */
public class LeetCode236 {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }
        if (left != null && right == null) {
            return left;
        }

        return right;
    }

}
