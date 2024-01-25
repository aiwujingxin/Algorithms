package leetcode.problems;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/18 15:30
 */
public class LeetCode1022 {

    int ans;

    public int sumRootToLeaf(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    public void dfs(TreeNode root, int sum) {
        if (root.left == null && root.right == null) {
            ans += sum * 2 + root.val;
            return;
        }
        if (root.left != null) {
            dfs(root.left, 2 * sum + root.val);
        }
        if (root.right != null) {
            dfs(root.right, 2 * sum + root.val);
        }
    }
}

