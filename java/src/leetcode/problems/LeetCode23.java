package leetcode.problems;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/6 17:30
 */
public class LeetCode23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeKLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeKLists(ListNode[] lists, int left, int right) {
        if (left >= right) {
            return lists[left];
        }
        int mid = (left + right) / 2;
        ListNode list1 = mergeKLists(lists, left, mid);
        ListNode list2 = mergeKLists(lists, mid + 1, right);
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
