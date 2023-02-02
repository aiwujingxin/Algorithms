package leetcode.lists.hot100;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/5 22:40
 */
public class LeetCode337 {

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] result = find(root);
        return Math.max(result[0], result[1]);
    }

    private int[] find(TreeNode root) {
        int[] result = new int[2];
        if (root == null) {
            return result;
        }
        //0 偷
        //1 不偷
        int[] left = find(root.left);
        int[] right = find(root.right);
        result[0] = root.val + left[1] + right[1];
        result[1] = Math.max(left[1], left[0]) + Math.max(right[1], right[0]);
        return result;
    }
}
