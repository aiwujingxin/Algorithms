package leetcode.plan.datastructure.level1;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/16 14:09
 */
public class LeetCode112 {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        //fix
        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}
