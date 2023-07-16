package leetcode.problems;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/20 10:57
 */
public class LeetCode112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
