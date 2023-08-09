package leetcode.problems;

import common.*;

/**
 * @author jingxinwu
 * @date 2021-12-19 6:50 PM
 */
public class LeetCode1038 {

    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        bstToGst(root.right);
        sum += root.val;
        root.val = sum;
        bstToGst(root.left);
    }
}
