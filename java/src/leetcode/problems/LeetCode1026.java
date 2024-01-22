package leetcode.problems;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/22 15:42
 */
public class LeetCode1026 {

    int res = 0;

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, root.val, root.val);
        return res;
    }

    public void dfs(TreeNode root, int min, int max) {
        if (root == null) {
            return;
        }
        res = Math.max(res, Math.max(root.val - min, max - root.val));
        dfs(root.left, Math.min(min, root.val), Math.max(max, root.val));
        dfs(root.right, Math.min(min, root.val), Math.max(max, root.val));
    }
}
