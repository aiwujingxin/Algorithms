package leetcode.lists.LCP;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/24 10:11
 */
public class LCP64_WA {

    public int closeLampInTree(TreeNode root) {
        int[] res = dfs(root);
        return Math.min(res[0], res[1] + 1);
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        if (root.left == null && root.right == null) {
            if (root.val == 1) {
                return new int[]{1, 0};
            }
            return new int[]{0, 1};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int zero;
        int one;
        if (root.val == 0) {
            zero = Math.min(Math.min(Math.min(left[0] + right[0], left[0] + right[1] + 1), left[1] + right[0] + 1),
                    left[1] + right[1] + 2);
            one = Math.min(Math.min(Math.min(left[0] + right[0] + 1, left[0] + right[1] + 2), left[1] + right[0] + 2),
                    left[1] + right[1] + 1);
        } else {
            zero = Math.min(Math.min(Math.min(left[0] + right[0] + 1, left[0] + right[1] + 2), left[1] + right[0] + 2),
                    left[1] + right[1] + 1);
            one = Math.min(Math.min(Math.min(left[0] + right[0] + 2, left[0] + right[1] + 1), left[1] + right[0] + 1),
                    left[1] + right[1]);
        }
        return new int[]{zero, one};
    }
}
