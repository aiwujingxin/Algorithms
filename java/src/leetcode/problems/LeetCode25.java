package leetcode.problems;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 16:07
 */
public class LeetCode25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null) return head;
            tail = tail.next;
        }
        ListNode newHead = reverse(head, tail);
        head.next = reverseKGroup(tail, k);
        return newHead;
    }

    public ListNode reverseKGroup_itr(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy;
        while (cur.next != null) {
            for (int i = 0; i < k && cur != null; i++) {
                cur = cur.next;
            }
            if (cur == null) break;
            ListNode start = pre.next;
            ListNode nextGHead = cur.next;
            pre.next = reverse(start, nextGHead);
            start.next = nextGHead;
            pre = start;
            cur = start;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode h, ListNode t) {
        ListNode c = h;
        ListNode p = null;
        while (c != t) {
            ListNode n = c.next;
            c.next = p;
            p = c;
            c = n;
        }
        return p;
    }

}
