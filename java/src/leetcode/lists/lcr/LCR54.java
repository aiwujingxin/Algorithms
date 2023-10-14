package leetcode.lists.lcr;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/24 10:41
 */
public class LCR54 {

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        sum += root.val;
        root.val = sum;
        dfs(root.left);
    }
}
