package leetcode.lists.hot100;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/7 01:41
 */
public class LeetCode114_dfs {
    TreeNode flag = new TreeNode();

    public void flatten(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        flag = root;
        TreeNode l = flag.left;
        TreeNode r = flag.right;
        root.left = null;
        root.right = null;
        dfs(l);
        dfs(r);
    }

    void dfs(TreeNode p) {
        if (p == null) {
            return;
        }

        TreeNode l = p.left;
        TreeNode r = p.right;
        // 断开
        p.left = null;
        p.right = null;
        flag.right = p;
        flag = p;
        dfs(l);
        dfs(r);
    }
}
