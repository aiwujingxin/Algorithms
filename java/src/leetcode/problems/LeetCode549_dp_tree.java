package leetcode.problems;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/16 15:43
 */
public class LeetCode549_dp_tree {

    private int max = 0;

    public int longestConsecutive(TreeNode root) {
        longestPath(root);
        return max;
    }

    public int[] longestPath(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int inc = 1;
        int dec = 1;
        if (root.left != null) {
            int[] left = longestPath(root.left);
            if (root.left.val == root.val + 1) {
                inc += left[0];
            }
            if (root.left.val == root.val - 1) {
                dec += left[1];
            }
        }
        if (root.right != null) {
            int[] right = longestPath(root.right);
            if (root.right.val == root.val + 1) {
                inc = Math.max(inc, right[0] + 1);
            }
            if (root.right.val == root.val - 1) {
                dec = Math.max(dec, right[1] + 1);
            }
        }
        max = Math.max(max, inc + dec - 1);
        return new int[]{inc, dec};
    }
}
