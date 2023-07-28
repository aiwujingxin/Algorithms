package leetcode.problems;

import common.*;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/21 16:51
 */
public class LeetCode865_v1 {

    HashSet<Integer> set;
    int maxDepth;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) {
            return null;
        }
        set = new HashSet<>();
        maxDepth = dfs(root);
        dfs1(root, 1);
        return getLowestCommonAncestor(root, set);
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        return 1 + Math.max(left, right);
    }

    public void dfs1(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (depth == maxDepth) {
            set.add(root.val);
        }
        dfs1(root.left, depth + 1);
        dfs1(root.right, depth + 1);
    }

    public TreeNode getLowestCommonAncestor(TreeNode root, HashSet<Integer> set) {
        if (root == null) {
            return null;
        }
        if (set.contains(root.val)) {
            return root;
        }
        TreeNode left = getLowestCommonAncestor(root.left, set);
        TreeNode right = getLowestCommonAncestor(root.right, set);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
