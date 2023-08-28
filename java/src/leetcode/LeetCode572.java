package leetcode;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/29 00:15
 */
public class LeetCode572 {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        return subtree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean subtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return subtree(s.left, t.left) && subtree(s.right, t.right);
    }
}
