package leetcode.lists.LCR;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/24 11:11
 */
public class LCR52 {

    TreeNode dummy;
    TreeNode cur;

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        dummy = new TreeNode();
        cur = dummy;
        dfs(root);
        return dummy.right;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        cur.right = root;
        root.left = null;
        cur = root;
        dfs(root.right);
    }
}
