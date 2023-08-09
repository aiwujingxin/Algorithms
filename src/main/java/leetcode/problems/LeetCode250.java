package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/8 18:04
 */
public class LeetCode250 {

    int res = 0;

    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (dfs(root, root.val)) {
            res++;
        }
        countUnivalSubtrees(root.left);
        countUnivalSubtrees(root.right);
        return res;
    }

    public boolean dfs(TreeNode node, int val) {
        if (node == null) {
            return true;
        }
        if (node.val != val) {
            return false;
        }
        return dfs(node.left, val) && dfs(node.right, val);
    }
}
