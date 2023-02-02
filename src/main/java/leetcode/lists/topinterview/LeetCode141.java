package leetcode.lists.topinterview;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/24 23:16
 */
public class LeetCode141 {

    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next; //fixed

        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }

            slow = slow.next;
            fast = fast.next.next;
        }
        return false;

    }
}
