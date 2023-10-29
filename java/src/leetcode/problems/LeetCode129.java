package leetcode.problems;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/29 16:46
 */
public class LeetCode129 {

    int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            sum += val * 10 + root.val;
            return;
        }
        dfs(root.left, val * 10 + root.val);
        dfs(root.right, val * 10 + root.val);
    }
}
