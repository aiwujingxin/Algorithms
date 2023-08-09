package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/16 16:09
 */
public class LeetCode333 {


    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            return cnt(root);
        }
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }

    private int cnt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return cnt(root.left) + cnt(root.right) + 1;
    }


    public boolean dfs(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return dfs(node.left, min, node.val) && dfs(node.right, node.val, max);
    }

}
