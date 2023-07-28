package leetcode.lists.topinterview;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/28 22:32
 */
public class LeetCode236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }

        if (p == root) {
            return p;
        }

        if (q == root) {
            return q;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }
        if (left == null) {
            return right;
        }
        return left;

    }
}
