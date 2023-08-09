package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/28 21:39
 */
public class LeetCode98_dp_tree {

    boolean ret = true;

    public boolean isValidBST(TreeNode root) {
        dfs(root);
        return ret;
    }

    private long[] dfs(TreeNode root) {
        if (root == null) {
            return new long[]{Long.MAX_VALUE, Long.MIN_VALUE};
        }
        long[] left = dfs(root.left);
        long[] right = dfs(root.right);
        if (left[1] < root.val && root.val < right[0]) {
            return new long[]{
                    Math.min(left[0], root.val), Math.max(right[1], root.val)};
        }
        ret = false;
        return new long[]{Long.MIN_VALUE, Long.MAX_VALUE};
    }
}
