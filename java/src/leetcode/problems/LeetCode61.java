package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/24 11:26
 */
public class LeetCode61 {

    public ListNode rotateRight(ListNode head, int k) {
        int len = getLen(head);
        if (k == 0 || len == 0) {
            return head;
        }
        k = k % len;
        if (k == 0) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        for (int i = 0; i < len - k; i++) {
            cur = cur.next;
        }
        ListNode newHead = cur.next;
        cur.next = null;
        cur = newHead;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = head;
        return newHead;
    }

    private int getLen(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
