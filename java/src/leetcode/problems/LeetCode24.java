package leetcode.problems;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 15:59
 */
public class LeetCode24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

    public ListNode swapPairs_itr(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode c = dummy;
        while (c.next != null && c.next.next != null) {
            ListNode a = c.next;
            ListNode b = c.next.next;
            a.next = b.next;
            b.next = a;
            c.next = b;
            c = a;
        }
        return dummy.next;
    }
}
