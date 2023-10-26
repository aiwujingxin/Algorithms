package leetcode.problems;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/27 04:41
 */
public class LeetCode92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;
        // step1
        ListNode start = dummy;
        for (int i = 0; i < left - 1; i++) {
            start = start.next;
        }
        ListNode end = dummy;
        for (int i = 0; i < right; i++) {
            end = end.next;
        }
        ListNode next = end.next;
        end.next = null;
        // step2
        ListNode rhead = reverse(start.next, end);

        // step3
        start.next = rhead;
        ListNode cur = rhead;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = next;
        return dummy.next;
    }

    private ListNode reverse(ListNode start, ListNode end) {
        ListNode pre = null;
        ListNode cur = start;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}