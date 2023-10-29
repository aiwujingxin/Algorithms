package leetcode.problems;

import common.ListNode;
import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/29 15:03
 */
public class LeetCode109 {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return sortedListToBST(head, null);
    }

    public TreeNode sortedListToBST(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }
        int len = getLen(head, tail);
        ListNode cur = head;
        for (int i = 0; i < len / 2; i++) {
            cur = cur.next;
        }
        TreeNode root = new TreeNode(cur.val);
        root.left = sortedListToBST(head, cur);
        root.right = sortedListToBST(cur.next, tail);
        return root;
    }

    private int getLen(ListNode head, ListNode tail) {
        int len = 0;
        ListNode cur = head;
        while (cur != tail) {
            cur = cur.next;
            len++;
        }
        return len;
    }
}
