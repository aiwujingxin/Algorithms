package leetcode.problems;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/28 21:45
 */
public class LeetCode1080 {

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return dfs(root, 0, limit);
    }

    public TreeNode dfs(TreeNode root, int sum, int limit) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root.val + sum < limit ? null : root;
        }
        root.left = dfs(root.left, sum + root.val, limit);
        root.right = dfs(root.right, sum + root.val, limit);
        return root.left == null && root.right == null ? null : root;
    }
}
