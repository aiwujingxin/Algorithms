package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/29 13:04
 */
public class LeetCode1740 {

    public int findDistance(TreeNode root, int p, int q) {
        TreeNode parent = LCA(root, p, q);
        int l = dfs(parent, p);
        int r = dfs(parent, q);
        return l + r;
    }

    TreeNode LCA(TreeNode root, int p, int q) {
        if (root == null) {
            return null;
        }
        if (root.val == p || root.val == q) {
            return root;
        }
        TreeNode l = LCA(root.left, p, q);
        TreeNode r = LCA(root.right, p, q);
        if (r != null && l != null) {
            return root;
        }
        return l == null ? r : l;
    }

    int dfs(TreeNode root, int x) {
        if (root == null) {
            return -1;
        }
        if (root.val == x) {
            return 0;
        }
        int l = dfs(root.left, x);
        int r = dfs(root.right, x);
        if (l == -1 && r == -1) {
            return -1;
        }
        return Math.max(l, r) + 1;
    }
}
