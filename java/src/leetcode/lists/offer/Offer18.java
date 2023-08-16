package leetcode.lists.offer;

import common.ListNode;

/**
 * @author jingxinwu
 * @date 2021-11-21 2:50 下午
 */
public class Offer18 {

    public ListNode deleteNode(ListNode head, int val) {

        if (head == null) {
            return head;
        }
        if (head.val == val && head.next == null) {
            return null;
        }

        if (head.val != val && head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = first.next;

        while (second != null) {
            if (second.val == val) {
                first.next = second.next;
                break;
            }

            first = first.next;
            second = second.next;
        }

        return dummy.next;
    }

}
