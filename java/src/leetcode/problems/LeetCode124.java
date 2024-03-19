package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/18 17:26
 */
public class LeetCode124 {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        max = Math.max(max, root.val);
        max = Math.max(max, root.val + left);
        max = Math.max(max, root.val + right);
        max = Math.max(max, root.val + right + left);
        return Math.max(root.val, Math.max(root.val + left, root.val + right));
    }
}
