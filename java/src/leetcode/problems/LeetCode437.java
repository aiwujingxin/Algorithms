package leetcode.problems;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/29 18:44
 */
public class LeetCode437 {
    int res = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        dfs(root, 0, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return res;
    }

    private void dfs(TreeNode root, long sum, int targetSum) {
        if (root == null) {
            return;
        }
        sum += root.val;
        if (sum == targetSum) {
            res++;
        }
        dfs(root.left, sum, targetSum);
        dfs(root.right, sum, targetSum);
    }
}


