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

    public ListNode reverseKGroup_itr(ListNode head, int k) {
        ListNode d = new ListNode(0, head);
        ListNode c = d;
        while (true) {
            ListNode t = c;
            for (int i = 0; i < k && t != null; i++) {
                t = t.next;
            }
            if (t == null) break;
            ListNode s = c.next;
            ListNode e = t.next;
            c.next = reverse(s, e);
            s.next = e;
            c = s;
        }
        return d.next;
    }
}
