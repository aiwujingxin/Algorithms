package leetcode.lists.lcr;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/25 17:31
 */
public class LCR77 {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode sorted = head;
        ListNode cur = sorted.next;
        while (cur != null) {
            if (cur.val > sorted.val) {
                sorted = sorted.next;
            } else {
                ListNode pre = dummy;
                while (pre.next.val < cur.val) {
                    pre = pre.next;
                }
                ListNode next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
                sorted.next = next;
            }
            cur = sorted.next;
        }
        return dummy.next;
    }
}
