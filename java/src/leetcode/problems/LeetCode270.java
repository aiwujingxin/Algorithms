package leetcode.problems;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/9 22:22
 */
public class LeetCode270 {

    double min = Integer.MAX_VALUE;
    int res;

    public int closestValue(TreeNode root, double target) {

        if (root == null) {
            return 0;
        }
        closestValue(root.left, target);
        if (Math.abs(root.val - target) < min) {
            min = Math.abs(root.val - target);
            res = root.val;
        }
        closestValue(root.right, target);
        return res;
    }

    //===opt
    public int closestValue_opt(TreeNode root, double target) {
        int closest = root.val;
        while (root != null) {
            closest = Math.abs(root.val - target) < Math.abs(closest - target) ? root.val : closest;
            root = target < root.val ? root.left : root.right;
        }
        return closest;
    }
}
