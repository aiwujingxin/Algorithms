package leetcode.problems;

import common.*;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/12 13:04
 */
public class LeetCode99 {

    TreeNode x, y, pre;

    public void recoverTree(TreeNode root) {
        dfs(root);
        int t = x.val;
        x.val = y.val;
        y.val = t;
    }

    void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (pre != null && root.val < pre.val) {
            if (x == null) {
                x = pre;
            }
            y = root;
        }
        pre = root;
        dfs(root.right);
    }
}
