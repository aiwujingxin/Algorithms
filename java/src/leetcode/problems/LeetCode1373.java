package leetcode.problems;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/23 14:53
 * @see LeetCode333
 */
public class LeetCode1373 {

    private int ans;

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        if (root.val <= left[1] || root.val >= right[0]) {
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        }
        int val = left[2] + right[2] + root.val;
        ans = Math.max(ans, val);
        return new int[]{Math.min(left[0], root.val), Math.max(right[1], root.val), val};
    }
}
