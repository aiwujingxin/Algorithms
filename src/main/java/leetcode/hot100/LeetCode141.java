package leetcode.hot100;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/15 23:36
 */
public class LeetCode141 {

    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        //fix
        while (fast.next != null && fast.next.next != null) {

            if (slow == fast) {
                return true;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return false;

    }
}
