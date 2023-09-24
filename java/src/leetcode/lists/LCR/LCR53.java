package leetcode.lists.LCR;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/24 11:17
 */
public class LCR53 {

    TreeNode res;
    boolean find;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        dfs(root, p);
        return res;
    }

    private void dfs(TreeNode root, TreeNode p) {
        if (root == null) {
            return;
        }

        dfs(root.left, p);
        if (find && res != null) {
            res = root;
        }
        if (root == p) {
            find = true;
        }
        dfs(root.right, p);
        if (find) {
            res = root;
        }
    }
}
