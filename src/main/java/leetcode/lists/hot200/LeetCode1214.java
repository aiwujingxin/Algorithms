package leetcode.lists.hot200;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/2 15:43
 */
public class LeetCode1214 {

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if (root1 == null) {
            return false;
        }
        return find(root2, target - root1.val) || twoSumBSTs(root1.left, root2, target) || twoSumBSTs(root1.right, root2, target);
    }

    private boolean find(TreeNode root, int value) {
        if (root == null) {
            return false;
        }
        if (root.val == value) {
            return true;
        } else if (root.val < value) {
            return find(root.right, value);
        } else {
            return find(root.left, value);
        }
    }
}

