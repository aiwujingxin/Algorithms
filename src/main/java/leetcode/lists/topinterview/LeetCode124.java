package leetcode.lists.topinterview;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/28 02:25
 */
public class LeetCode124 {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        if (root == null) {
            return 0;
        }

        maxGain(root);
        return max;
    }

    private int maxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(maxGain(root.left), 0);
        int right = Math.max(maxGain(root.right), 0);


        int path = root.val + left + right;
        max = Math.max(max, path);

        return root.val + Math.max(left, right);

    }
}
