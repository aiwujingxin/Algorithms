package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/26 18:53
 */
public class LeetCode1367 {

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null && head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (head == null) {
            return true;
        }
        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean dfs(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (head.val == root.val) {
            return dfs(head.next, root.right) || dfs(head.next, root.left);
        }
        return false;
    }
}
