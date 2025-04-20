package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 16:07
 */
public class LeetCode25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }
        ListNode newHead = reverse(head, tail);
        head.next = reverseKGroup(tail, k);
        return newHead;
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
