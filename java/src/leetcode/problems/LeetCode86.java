package leetcode.problems;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/25 22:00
 */
public class LeetCode86 {

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode left = dummy;
        while (left.next != null) {
            if (left.next.val < x) {
                left = left.next;
            } else {
                ListNode right = left.next;
                while (right.next != null && right.next.val >= x) {
                    right = right.next;
                }
                if (right.next == null) {
                    return dummy.next;
                }
                ListNode next = right.next;

                right.next = next.next;
                next.next = left.next;
                left.next = next;

                left = left.next;
            }
        }
        return dummy.next;
    }
}
