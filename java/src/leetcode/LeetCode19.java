package leetcode;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/15 23:56
 */
public class LeetCode19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fast = dummy;
        while (n-- > 0) {
            fast = fast.next;
        }
        ListNode cur = dummy;
        while (fast.next != null) {
            fast = fast.next;
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }
}
