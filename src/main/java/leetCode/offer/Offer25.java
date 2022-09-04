package leetCode.offer;

import common.ListNode;

/**
 * @author jingxinwu
 * @date 2021-08-19 1:28 上午
 */
public class Offer25 {

    public static void main(String[] args) {
        Offer25 offer25 = new Offer25();

        ListNode first = new ListNode(-9);
        ListNode first1 = new ListNode(3);
        first.next = first1;
        ListNode second = new ListNode(5);
        ListNode second1 = new ListNode(7);
        second.next = second1;
        offer25.mergeTwoLists(first, second);
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }

        while (l1 != null) {
            cur.next = l1;
            l1 = l1.next;
        }

        while (l2 != null) {
            cur.next = l2;
            l2 = l2.next;
        }
        return dummy.next;
    }

    public ListNode mergeTwoListsV2(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(0), cur = dum;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dum.next;
    }

}
