package leetcode.lists.offer;

import common.TreeNode;

/**
 * @author jingxinwu
 * @date 2021-11-27 2:56 下午
 */
public class Offer68_2 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        int x1 = p.val;
        int x2 = q.val;
        if (root.val == x1 || root.val == x2) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null) {
            return null;
        }
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}
