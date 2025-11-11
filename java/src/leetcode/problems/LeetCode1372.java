package leetcode.problems;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/25 23:52
 */
public class LeetCode1372 {
    int max = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root);
        return max;
    }

    public int[] dfs(TreeNode root) {
        if (root == null) return new int[2];
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        max = Math.max(Math.max(left[1], right[0]), max);
        return new int[]{left[1] + 1, right[0] + 1};
    }
}
