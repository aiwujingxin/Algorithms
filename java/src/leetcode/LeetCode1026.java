package leetcode;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/18 15:42
 */
public class LeetCode1026 {

    int ans;

    public int maxAncestorDiff(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        }
        int mn = root.val;
        int mx = root.val;
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        // 思路可以少写很多代码
        mn = Math.min(mn, Math.min(left[0], right[0]));
        mx = Math.max(mx, Math.max(left[1], right[1]));
        ans = Math.max(ans, Math.max(root.val - mn, mx - root.val));
        return new int[]{mn, mx};
    }
}
