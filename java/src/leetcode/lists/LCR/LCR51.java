package leetcode.lists.LCR;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/24 10:41
 */
public class LCR51 {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        max = Math.max(max, left + right + root.val);
        return Math.max(0, Math.max(left, right) + root.val);
    }
}
