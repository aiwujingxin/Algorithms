package leetcode.problems;


import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/21 12:21
 */
public class LeetCode99 {

    TreeNode large = null;
    TreeNode secondLarge = null;
    TreeNode pre = null;

    public void recoverTree(TreeNode root) {
        dfs(root);
        int v = large.val;
        large.val = secondLarge.val;
        secondLarge.val = v;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre != null) {
            // 逆序
            if (root.val < pre.val) {
                if (large == null) {
                    large = pre;
                    secondLarge = root;
                } else {
                    if (root.val < secondLarge.val) {
                        secondLarge = root;
                    }
                }
            }
        }
        pre = root;
        dfs(root.right);
    }
}