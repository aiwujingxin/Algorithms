package leetcode.problems;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/27 20:45
 * @description 给定一个二叉树，找到其中最大的二叉搜索树（BST）子树，并返回该子树的大小。其中，最大指的是子树节点数最多的。
 */
public class LeetCode333 {

    private int ans;

    public int largestBSTSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        if (root.val <= left[1] || root.val >= right[0]) {
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        }
        int[] res = new int[3];
        res[0] = Math.min(left[0], root.val);
        res[1] = Math.min(right[1], root.val);
        res[2] = left[2] + right[2] + 1;
        ans = Math.max(ans, res[2]);
        return res;
    }
}
