package LeetCode;

import common.ListNode;

/**
 * @author jingxinwu
 * @date 2021-08-04 1:30 上午
 */
public class LeetCode147 {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode curr = head;
        ListNode temp = null;
        ListNode prev = null;
        while (curr != null && curr.next != null) {
            if (curr.val <= curr.next.val) {
                curr = curr.next;
            } else {
                temp = curr.next;
                curr.next = curr.next.next;
                prev = dummyHead;
                while (prev.next.val <= temp.val) {
                    prev = prev.next;
                }
                temp.next = prev.next;
                prev.next = temp;
            }
        }
        return dummyHead.next;
    }

}
