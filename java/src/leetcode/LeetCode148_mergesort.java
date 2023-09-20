package leetcode;

import common.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/9/12 21:47
 */
public class LeetCode148_mergesort {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode mid = getMid(head);
        ListNode head1 = mid.next;
        mid.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(head1);
        return mergeTwoLists(l1, l2);
    }

    private ListNode getMid(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode s = dummy;
        ListNode f = dummy;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if (l1 != null) {
            temp.next = l1;
        } else {
            temp.next = l2;
        }
        return dummy.next;
    }
}
