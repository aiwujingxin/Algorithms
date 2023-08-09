package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/24 06:06
 */
public class LeetCode623_dfs {

    int d, v;

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        d = depth;
        v = val;
        dfs(root, 1);
        return root;
    }

    void dfs(TreeNode root, int cur) {
        if (root == null) {
            return;
        }
        if (cur == d - 1) {
            TreeNode a = new TreeNode(v), b = new TreeNode(v);
            a.left = root.left;
            b.right = root.right;
            root.left = a;
            root.right = b;
            return;
        }
        dfs(root.left, cur + 1);
        dfs(root.right, cur + 1);
    }
}
