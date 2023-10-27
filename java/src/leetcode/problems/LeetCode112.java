package leetcode.problems;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/27 18:31
 */
public class LeetCode112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return dfs(root, targetSum);
    }

    private boolean dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.right == null && root.left == null) {
            if (targetSum == root.val) {
                return true;
            }
        }
        return dfs(root.left, targetSum - root.val) ||
                dfs(root.right, targetSum - root.val);
    }
}
