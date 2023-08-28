package leetcode;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/28 22:24
 */
public class LeetCode404 {

    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        sum = 0;
        traverse(root);
        return sum;
    }

    public void traverse(TreeNode root) {
        if (root == null)
            return;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        traverse(root.left);
        traverse(root.right);
    }

}
