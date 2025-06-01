package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/11 11:11
 */
public class LeetCode92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode l = dummy;
        for (int i = 0; i < left - 1; i++) {
            l = l.next;
        }
        ListNode r = dummy;
        for (int i = 0; i < right; i++) {
            r = r.next;
        }
        ListNode s = l.next;
        ListNode next = r.next;
        l.next = null;
        r.next = null;

        l.next = reverse(s);
        s.next = next;
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
