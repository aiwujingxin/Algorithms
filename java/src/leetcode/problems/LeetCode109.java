package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/16 23:47
 */
public class LeetCode109 {

    public TreeNode sortedListToBST(ListNode h) {
        return dfs(h, null);
    }

    TreeNode dfs(ListNode l, ListNode r) {
        if (l == r) return null;
        ListNode s = l, f = l;
        while (f.next != r && f.next.next != r) {
            s = s.next;
            f = f.next.next;
        }
        TreeNode t = new TreeNode(s.val);
        t.left = dfs(l, s);
        t.right = dfs(s.next, r);
        return t;
    }
}
