package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/16 14:46
 */
public class LeetCode111 {
    int res = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root, 1);
        return res;
    }

    private void dfs(TreeNode root, int i) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            res = Math.min(res, i);
            return;
        }
        dfs(root.left, i + 1);
        dfs(root.right, i + 1);
    }
}
