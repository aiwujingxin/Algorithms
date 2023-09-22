package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/17 21:07
 */
public class LeetCode337_dp {

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int[] res = new int[2];
        // 偷
        res[0] = left[1] + right[1] + root.val;
        // 不偷
        res[1] = Math.max(left[1], left[0]) + Math.max(right[1], right[0]);
        return res;
    }
}
