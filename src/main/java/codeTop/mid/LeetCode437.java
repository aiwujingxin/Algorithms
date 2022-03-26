package codeTop.mid;

import common.TreeNode;

/**
 * @author jingxinwu
 * @date 2022-02-25 7:42 PM
 */
public class LeetCode437 {


    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = rootSum(root, targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;
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
        /**17
         *
         *           8
         *         9
         *      13
         *    2
         *  2
         *1
         * */
        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum - val);
        return ret;
    }


}
