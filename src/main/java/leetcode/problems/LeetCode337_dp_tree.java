package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/23 13:37
 */
public class LeetCode337_dp_tree {

    //每个节点只计算一次，整体递归整个树。复杂度恒等于N
    public int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }

    public int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        //0 代表不偷，1 代表偷
        int[] result = new int[2];
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + root.val;
        return result;
    }
}
