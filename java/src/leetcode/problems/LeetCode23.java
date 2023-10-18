package leetcode.problems;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/18 17:45
 */
public class LeetCode23 {


    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeKLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (start >= end) {
            return lists[start];
        }
        int mid = (start + end) / 2;
        ListNode list1 = mergeKLists(lists, start, mid);
        ListNode list2 = mergeKLists(lists, mid + 1, end);

        return merge(list1, list2);
    }

    public ListNode merge(ListNode list1, ListNode list2) {
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
        while (list1 != null) {
            cur.next = list1;
            list1 = list1.next;
            cur = cur.next;
        }
        while (list2 != null) {
            cur.next = list2;
            list2 = list2.next;
            cur = cur.next;
        }
        return dummy.next;

    }
}
