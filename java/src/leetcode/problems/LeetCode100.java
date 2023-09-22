package leetcode.problems;

import common.TreeNode;

/**
 * @author jingxinwu
 * @date 2021-07-04 8:47 下午
 */
public class LeetCode100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
