package leetcode.problems;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/29 00:15
 * @see leetcode.lists.lcr.LCR145 //diff with LCR145
 */
public class LeetCode572 {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return false;
        }
        return dfs(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean dfs(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null) {
            return false;
        }
        if (t == null) {
            return false; //diff with LCR145
        }
        if (s.val != t.val) {
            return false;
        }
        return dfs(s.left, t.left) && dfs(s.right, t.right);
    }
}
