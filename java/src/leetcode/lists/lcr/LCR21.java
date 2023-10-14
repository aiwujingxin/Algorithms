package leetcode.lists.lcr;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/23 20:52
 */
public class LCR21 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        while (n-- > 0) {
            fast = fast.next;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while (fast != null) {
            fast = fast.next;
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }
}
