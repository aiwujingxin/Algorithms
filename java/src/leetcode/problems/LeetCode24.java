package leetcode.problems;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 15:59
 */
public class LeetCode24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

    public ListNode swapPairs_itr(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode a = cur.next, b = cur.next.next;
            a.next = b.next;
            b.next = a;
            cur.next = b;
            cur = a;
        }
        return dummy.next;
    }
}
