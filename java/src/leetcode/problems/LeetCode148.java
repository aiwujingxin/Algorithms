package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/2 13:50
 */
public class LeetCode148 {

    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == tail) {
            return head;
        }
        ListNode mid = getMid(head, tail);
        System.out.println(mid.val);

        ListNode newHead = mid.next;
        mid.next = null;
        ListNode l1 = sortList(head, mid);
        ListNode l2 = sortList(newHead, tail);
        return mergeTwoLists(l1, l2);
    }

    public ListNode getMid(ListNode head, ListNode tail) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (list1 != null || list2 != null) {
            int v1 = list1 == null ? Integer.MAX_VALUE : list1.val;
            int v2 = list2 == null ? Integer.MAX_VALUE : list2.val;
            if (v1 < v2) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
