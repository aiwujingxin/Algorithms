package leetplan.algorithm.level1;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/9 21:39
 */
public class LeetCode876 {

    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }
}
