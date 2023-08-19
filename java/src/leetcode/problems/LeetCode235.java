package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/18 22:43
 * @see LeetCode1740
 * @see LeetCode236
 * @see LeetCode1650
 * @see LeetCode1676
 */
public class LeetCode235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        return right;

    }
}
