package leetcode.problems;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/14 18:57
 */
public class LeetCode298 {

    int ans = 0;

    public int longestConsecutive(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 1;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (root.left != null) {
            if (root.left.val == root.val + 1) {
                res = Math.max(res, left + 1);
            }
        }
        if (root.right != null) {
            if (root.right.val == root.val + 1) {
                res = Math.max(res, right + 1);
            }
        }
        ans = Math.max(ans, res);
        return res;
    }
}
