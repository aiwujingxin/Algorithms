package leetcode.lists.lcr;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/23 20:54
 */
public class LCR22 {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;

        while (fast!=null && fast.next !=null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
