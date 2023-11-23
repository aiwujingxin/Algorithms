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
        // find start
        ListNode start = dummy;
        for (int i = 0; i < left - 1; i++) {
            start = start.next;
        }
        // reverse
        ListNode pre = null;
        ListNode cur = start.next;
        for (int i = 0; i < right - left + 1; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // connect
        start.next.next = cur;
        start.next = pre;
        return dummy.next;
    }
}