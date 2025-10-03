package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/11 11:11
 */
public class LeetCode92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        for (int i = 0; i < left - 1; i++) {
            cur = cur.next;
        }
        ListNode tail = dummy;
        for (int i = 0; i < right; i++) {
            tail = tail.next;
        }
        ListNode start = cur.next;
        ListNode next = tail.next;
        cur.next = reverse(start, next);
        start.next = next;
        return dummy.next;
    }

    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != tail) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
