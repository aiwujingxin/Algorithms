package leetcode.lists.lcr;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/12 21:58
 */
public class LCR143 {
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
