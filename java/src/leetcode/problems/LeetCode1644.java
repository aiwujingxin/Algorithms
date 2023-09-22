package leetcode.problems;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/31 22:11
 */
public class LeetCode1644 {
    boolean p;
    boolean q;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans = traversal(root, p.val, q.val);
        if (this.p && this.q) {
            return ans;
        }
        return null;
    }

    public TreeNode traversal(TreeNode node, int p, int q) {
        if (node == null) {
            return null;
        }
        TreeNode left = traversal(node.left, p, q);
        TreeNode right = traversal(node.right, p, q);
        if (left != null && right != null) {
            return node;
        }
        if (node.val == p || node.val == q) {
            if (node.val == p) {
                this.p = true;
            } else {
                this.q = true;
            }
            return node;
        }
        return left == null ? right : left;
    }
}
