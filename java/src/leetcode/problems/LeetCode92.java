package leetcode.problems;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/9 14:46
 */
public class LeetCode92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        for (int i = 0; i < left - 1; i++) {
            cur = cur.next;
        }
        ListNode end = dummy;
        for (int i = 0; i < right; i++) {
            end = end.next;
        }
        ListNode next = end.next;
        ListNode start = cur.next;
        cur.next = null;
        cur.next = reverse(start, end.next);
        start.next = next;
        return head;
    }

    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != tail) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
