package leetcode.offer;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/12 21:34
 */
public class Offer18 {

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur != null && cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
