package leetcode;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/16 00:37
 */
public class LeetCode23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return mergeKLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeKLists(ListNode[] list, int start, int end) {
        //fix
        if (start >= end) {
            return list[start];
        }
        int mid = (start + end) / 2;
        ListNode list1 = mergeKLists(list, start, mid);
        ListNode list2 = mergeKLists(list, mid + 1, end);
        return mergeTwoLists(list1, list2);
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

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }
        return dummy.next;
    }
}
