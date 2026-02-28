package leetcode.problems;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 15:59
 */
public class LeetCode24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    public ListNode swapPairs_itr(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode c = dummy;
        while (c.next != null && c.next.next != null) {
            ListNode f = c.next;
            ListNode s = c.next.next;
            f.next = s.next;
            s.next = f;
            c.next = s;
            c = f;
        }
        return dummy.next;
    }
}
