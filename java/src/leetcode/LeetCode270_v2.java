package leetcode;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/28 21:59
 */
public class LeetCode270_v2 {

    public int closestValue(TreeNode root, double target) {
        int closest = root.val;
        while (root != null) {
            closest = Math.abs(root.val - target) < Math.abs(closest - target) ? root.val : closest;
            root = target < root.val ? root.left : root.right;
        }
        return closest;
    }
}
