package codeTop.ms;

import common.TreeNode;

/**
 * @author jingxinwu
 * @date 2022-02-17 9:54 PM
 */
public class LeetCode337 {


    public int rob(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int[] result = helper(root);
        return Math.max(result[0], result[1]);

    }

    public int[] helper(TreeNode root) {

        if (root == null) {
            return new int[2];
        }
        int[] left = helper(root.left);
        int[] right = helper(root.right);

        int[] result = new int[2];
        //不偷
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //偷
        result[1] = root.val + left[0] + right[0];
        return result;
    }

}
