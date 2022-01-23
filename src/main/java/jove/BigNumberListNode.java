package jove;

import common.ListNode;

/**
 * @author jingxinwu
 * @date 2022-01-03 6:49 PM
 */
public class BigNumberListNode {

    //相加
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 != null) {
            return l2;
        }
        if (l2 == null && l1 != null) {
            return l1;
        }
        int status = 0;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null || l2 != null) {
            int one = l1 != null ? l1.val : 0;
            int two = l2 != null ? l2.val : 0;
            int sum = one + two + status;
            status = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
        }
        if (status == 1) {
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }

    //相减
    public ListNode subtractTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 != null) {
            return l2;
        }
        if (l2 == null && l1 != null) {
            return l1;
        }
        int status = 0;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null || l2 != null) {
            int one = l1 != null ? l1.val : 0;
            int two = l2 != null ? l2.val : 0;
            int sum = one + two + status;
            status = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
        }
        if (status == 1) {
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }
}
