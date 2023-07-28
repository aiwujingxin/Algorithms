package leetcode.problems;

import common.*;

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
        int l = leftRes[1] + 1;
        int r = rightRes[0] + 1;
        ans = Math.max(ans, Math.max(l, r));
        return new int[]{l, r};
    }
}
