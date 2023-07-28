package leetcode.lists.classic;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/25 17:26
 */
public class Number0410 {

    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return true;
        }
        if (t1 == null) {
            return false;
        }
        return isSameTree(t1, t2) || checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
    }

    private boolean isSameTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }

        if (t1 == null) {
            return false;
        }

        if (t2 == null) {
            return false;
        }

        return t1.val == t2.val && isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
    }

}
