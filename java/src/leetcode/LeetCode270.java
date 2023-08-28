package leetcode;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/9 22:22
 */
public class LeetCode270 {

    int res;
    double min = Integer.MAX_VALUE;

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
}
