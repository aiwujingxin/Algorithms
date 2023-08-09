package leetcode.problems;

import common.*;

public class LeetCode156 {

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode l = root.left;
        TreeNode r = root.right;
        root.left = null;
        root.right = null;
        return dfs(l, r, root);
    }

    public TreeNode dfs(TreeNode cur, TreeNode right, TreeNode root) {
        if (cur == null) {
            return root;
        }
        TreeNode next = cur.left;
        cur.left = right;
        TreeNode nextRight = cur.right;
        cur.right = root;
        return dfs(next, nextRight, cur);
    }
}
