package leetcode.problems;

import common.*;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/12 13:04
 */
public class LeetCode99 {

    TreeNode x = null, y = null, pred = null;

    public void recoverTree(TreeNode root) {
        inorder(root);
        int t = x.val;
        x.val = y.val;
        y.val = t;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (pred != null && root.val < pred.val) {
            y = root;
            if (x == null) {
                x = pred;
            } else {
                return; // 找到两个节点后可提前返回
            }
            pred = root;
            inorder(root.right);
        }
    }
}
