package basic.algorithm.tree.util;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/17 14:41
 */
public class TreeUtil {

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
