package sort;

import common.ListNode;

/**
 * @author jingxinwu
 * @date 2021-12-21 8:48 PM
 */
public class ListNodeInsertSort {
    //
    //          1       3        6          2        9
    //   dummy head
//                           lastSorted       cur
//             pre

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(6);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(2);
        ListNode e = new ListNode(9);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        insertionSortList(a);
    }

    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode lastSorted = head;
        ListNode curr = head.next;

        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode prev = dummyHead;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummyHead.next;
    }

}
