package basic.algorithm.sort;

import basic.structure.list.*;
import common.*;

/**
 * @author jingxinwu
 * @date 2021-12-21 8:48 PM
 */
public class ListNodeInsertSort implements ListSort {
    //
    //          1       3        6          2        9
    //   dummy head
//                           lastSorted       cur
//             pre

    @Override
    public ListNode sortList(ListNode head) {
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
