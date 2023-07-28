package leetcode.problems;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/18 16:49
 */
public class LeetCode1026_v1 {

    int ans;

    public static void main(String[] args) {
        System.out.println(new LeetCode1026_v1().maxAncestorDiff(new TreeNode(1, new TreeNode(2), new TreeNode(3))));
    }

    public int maxAncestorDiff(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int a = 0, b = 0, c = 0, d = 0;
        if (left != null) {
            a = Math.abs(root.val - left[0]);
            b = Math.abs(root.val - left[1]);
        }
        if (right != null) {
            c = Math.abs(right[0] - root.val);
            d = Math.abs(right[1] - root.val);
        }
        int mn = root.val;
        int mx = root.val;
        mn = Math.min(mn, Math.min(left == null ? Integer.MAX_VALUE : left[0], right == null ? Integer.MAX_VALUE : right[0]));
        mx = Math.max(mx, Math.max(left == null ? Integer.MIN_VALUE : left[1], right == null ? Integer.MIN_VALUE : right[1]));
        ans = Math.max(Math.max(Math.max(Math.max(a, b), c), d), ans);
        return new int[]{mn, mx};
    }
}
