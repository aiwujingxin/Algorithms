package codeTop.ms;

import common.ListNode;

/**
 * @author jingxinwu
 * @date 2022-02-16 3:19 PM
 */
public class LeetCode142 {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            //fix
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = head;
                while (slow != null && fast != null && slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;

            }
        }
        return null;

    }
}
