package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/17 11:08
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

    private void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            this.sum += sum * 10 + root.val;
            return;
        }
        dfs(root.left, sum * 10 + root.val);
        dfs(root.right, sum * 10 + root.val);
    }
}
