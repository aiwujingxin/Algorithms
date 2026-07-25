package leetcode.problems;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @see LeetCode236
 */

public class LeetCode2096 {
    String path;

    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lowest_root = lowestCommonAncestor(root, startValue, destValue);
        StringBuilder sb1 = new StringBuilder();
        find(lowest_root, startValue, sb1);
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < path.length(); i++) {
            ans.append("U");
        }
        // 3. 由lowest_root到t, 为L or R
        path = "";
        StringBuilder sb2 = new StringBuilder();
        find(lowest_root, destValue, sb2);
        ans.append(path);
        return ans.toString();
    }

    private TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

    // 在以root为根节点的二叉树中寻找c并记录path
    public void find(TreeNode root, int target, StringBuilder sb) {
        if (root.val == target) {
            path = sb.toString();
            return;
        }
        if (root.left != null) {
            sb.append("L");
            find(root.left, target, sb);
            sb.delete(sb.length() - 1, sb.length());
        }
        if (root.right != null) {
            sb.append("R");
            find(root.right, target, sb);
            sb.delete(sb.length() - 1, sb.length());
        }
    }
}
