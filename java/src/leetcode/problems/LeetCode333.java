package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/27 20:45
 * @see LeetCode1373
 * @see LeetCode549
 * @see LeetCode337
 * @see LeetCode2378
 * @see LeetCode124
 * @see LeetCode298
 * @see LeetCode687
 * @see LeetCode543
 * @see LeetCode1372
 * @see LeetCode1448
 * @see LeetCode1120
 * @see LeetCode1245
 * 换根DP
 * @see LeetCode310_dp
 * @see LeetCode2581
 * @see LeetCode834
 */
public class LeetCode333 {

    private int ans; // 二叉搜索树可以为空

    public int largestBSTSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        int[] left = dfs(root.left); // 递归左子树
        int[] right = dfs(root.right); // 递归右子树
        if (root.val <= left[1] || root.val >= right[0]) { // 不是二叉搜索树
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        }

        int s = left[2] + right[2] + 1; // 这棵子树的所有节点值之和
        ans = Math.max(ans, s);

        return new int[]{Math.min(left[0], root.val), Math.max(right[1], root.val), s};
    }
}
