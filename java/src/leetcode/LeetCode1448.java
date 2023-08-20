package leetcode;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/31 22:13
 */
public class LeetCode1448 {

    int res = 0;

    public int goodNodes(TreeNode root) {
        if (root == null) {
            return res;
        }
        dfs(root, root.val);
        return res;
    }

    public void dfs(TreeNode node, int max) {
        if (node == null) {
            return;
        }
        if (node.val >= max) {
            res++;
            max = node.val;
        }
        dfs(node.left, max);
        dfs(node.right, max);
    }
}
