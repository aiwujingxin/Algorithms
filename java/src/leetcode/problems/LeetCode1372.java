package leetcode.problems;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/25 23:52
 */
public class LeetCode1372 {
    int ans = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return ans;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{-1, -1};
        }
        int[] leftRes = dfs(root.left);
        int[] rightRes = dfs(root.right);
        int left = leftRes[1] + 1;
        int right = rightRes[0] + 1;
        ans = Math.max(ans, Math.max(left, right));
        return new int[]{left, right};
    }
}
