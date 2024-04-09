package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 15:57
 */
public class LeetCode23 {

    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        if (lo == hi) {
            return lists[lo];
        }
        int mid = (lo + hi) >> 1;
        ListNode list1 = mergeKLists(lists, lo, mid);
        ListNode list2 = mergeKLists(lists, mid + 1, hi);
        return mergeTwoLists(list1, list2);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (list1 != null || list2 != null) {
            int v1 = list1 != null ? list1.val : Integer.MAX_VALUE;
            int v2 = list2 != null ? list2.val : Integer.MAX_VALUE;
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
