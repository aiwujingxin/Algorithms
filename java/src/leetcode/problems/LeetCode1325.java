package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/20 22:34
 * @see LeetCode366
 * @see LeetCode814
 * @see LeetCode1080_v1
 */
public class LeetCode1325 {

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        return dfs(root, target);
    }

    private TreeNode dfs(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        root.left = dfs(root.left, target);
        root.right = dfs(root.right, target);
        if (root.val == target && root.left == null && root.right == null) {
            return null;
        }
        return root;
    }
}
