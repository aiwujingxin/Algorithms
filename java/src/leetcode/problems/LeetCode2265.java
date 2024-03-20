package leetcode.problems;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/14 21:35
 */
public class LeetCode2265 {

    int ans;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int sum = left[0] + right[0] + root.val;
        int nodeNum = left[1] + right[1] + 1;
        if (sum / nodeNum == root.val) {
            ans++;
        }
        return new int[]{sum, nodeNum};
    }
}
