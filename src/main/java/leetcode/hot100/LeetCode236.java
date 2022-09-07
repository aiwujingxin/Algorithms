package leetcode.hot100;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/7 23:34
 */
public class LeetCode236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return root;
        }

        if (root == p || root == q) {
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
