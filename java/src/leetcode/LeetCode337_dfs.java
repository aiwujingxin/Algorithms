package leetcode;

import common.TreeNode;

/**
 * @author jingxinwu
 * @date 2021-12-12 5:33 PM
 */
public class LeetCode337_dfs {

    //https://leetcode-cn.com/problems/house-robber-iii/solution/san-chong-fang-fa-jie-jue-shu-xing-dong-tai-gui-hu/

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int robRoot = root.val;
        if (root.left != null) {
            robRoot += (rob(root.left.left) + rob(root.left.right));
        }
        if (root.right != null) {
            robRoot += (rob(root.right.left) + rob(root.right.right));
        }

        int noRobRoot = rob(root.left) + rob(root.right);
        return Math.max(robRoot, noRobRoot);
    }
}
