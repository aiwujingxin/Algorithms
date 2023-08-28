package leetcode;

import common.TreeNode;

/**
 * @author jingxinwu
 * @date 2021-12-12 7:56 PM
 */
public class LeetCode437 {

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        return rootSum(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    public int rootSum(TreeNode root, int targetSum) {
        int ret = 0;

        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val == targetSum) {
            ret++;
        }
        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum - val);
        return ret;
    }

}
