package leetcode.problems;

import common.TreeNode;

public class LeetCode968_treedp {

    public int minCameraCover(TreeNode root) {
        int[] res = dfs(root);
        return Math.min(res[0], res[2]);
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{Integer.MAX_VALUE / 2, 0, 0}; // 除 2 防止加法溢出
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int choose = Math.min(left[0], left[1]) + Math.min(right[0], right[1]) + 1;
        int byFa = Math.min(left[0], left[2]) + Math.min(right[0], right[2]);
        int byChildren = Math.min(Math.min(left[0] + right[2], left[2] + right[0]), left[0] + right[0]);
        return new int[]{choose, byFa, byChildren};
    }
}
