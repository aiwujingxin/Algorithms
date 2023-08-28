package leetcode;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/29 00:15
 */
public class LeetCode563 {

    int tilt = 0;

    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return tilt;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        tilt += Math.abs(left - right);
        return left + right + root.val;
    }
}
