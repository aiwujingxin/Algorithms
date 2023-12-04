package leetcode.problems;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/20 22:06
 */
public class LeetCode1120 {

    double res = 0;

    public double maximumAverageSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return res;
    }

    private int[] dfs(TreeNode root) {
        int[] arr = new int[2];
        if (root == null) {
            return arr;
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        arr[0] = left[0] + right[0] + root.val;
        arr[1] = left[1] + right[1] + 1;
        res = Math.max(res, (double) arr[0] / arr[1]);
        return arr;
    }
}
