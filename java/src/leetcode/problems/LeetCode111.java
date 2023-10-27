package leetcode.problems;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/27 18:23
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

    private void dfs(TreeNode root, int cnt) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            res = Math.min(res, cnt);
        }
        dfs(root.left, cnt + 1);
        dfs(root.right, cnt + 1);
    }
}
