package leetcode.problems;

import common.TreeNode;

/**
 * @author jingxinwu
 * @date 2021-12-19 6:49 PM
 */
public class LeetCode538 {

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        int val = root.val;
        root.val += sum;
        sum += val;
        dfs(root.left);
    }
}
