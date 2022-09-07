package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2021-08-25 1:44 上午
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

    public TreeNode lowestCommonAncestorV2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        int x1 = p.val;
        int x2 = q.val;
        if (root.val == x1 || root.val == x2) {
            return root;
        }
        TreeNode left = lowestCommonAncestorV2(root.left, p, q);
        TreeNode right = lowestCommonAncestorV2(root.right, p, q);
        if (left == null && right == null) {
            return null;
        }
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}
