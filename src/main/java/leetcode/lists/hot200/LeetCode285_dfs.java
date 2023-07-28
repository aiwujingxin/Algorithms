package leetcode.lists.hot200;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/23 13:06
 */
public class LeetCode285_dfs {

    boolean flag;
    TreeNode res;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }

        return dfs(root, p);
    }

    private TreeNode dfs(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        dfs(root.left, p);
        if (flag) {
            res = root;
            flag = false;
        }
        if (root == p) {
            flag = true;
        }
        dfs(root.right, p);
        return res;
    }
}
