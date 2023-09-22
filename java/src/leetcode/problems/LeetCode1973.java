package leetcode.problems;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/13 12:18
 */
public class LeetCode1973 {

    int res;

    public int equalToDescendants(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);

        if (left + right == root.val) {
            res++;
        }
        return root.val + left + right;
    }
}
