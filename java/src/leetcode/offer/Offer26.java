package leetcode.offer;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/3 18:56
 * @see leetcode.LeetCode572
 */
public class Offer26 {
    public boolean isSubStructure(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return false;
        }
        return dfs(s, t) || isSubStructure(s.left, t) || isSubStructure(s.right, t);
    }

    private boolean dfs(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null) {
            return false;
        }
        if (t == null) {
            return true;
        }
        if (s.val != t.val) {
            return false;
        }
        return dfs(s.left, t.left) && dfs(s.right, t.right);
    }
}
