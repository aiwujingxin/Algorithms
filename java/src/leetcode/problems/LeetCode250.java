package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/8 18:04
 */
public class LeetCode250 {

    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        countUnivalSubtrees(root.right);
        return dfs(root, root.val) + countUnivalSubtrees(root.left) + countUnivalSubtrees(root.right);
    }

    public int dfs(TreeNode node, int val) {
        if (node == null) {
            return 1;
        }
        if (node.val != val) {
            return 0;
        }
        return dfs(node.left, val) + dfs(node.right, val);
    }
}
