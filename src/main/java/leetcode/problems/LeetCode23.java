package leetcode.problems;

import common.ListNode;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/9/13 00:36
 */
public class LeetCode23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return new ListNode();
        }
        return mergeKLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeKLists(ListNode[] list, int left, int right) {
        // 相当于递归终止条件
        if (left >= right) {
            return list[left];
        }
        int index = (left + right) / 2;
        ListNode list1 = mergeKLists(list, left, index);
        ListNode list2 = mergeKLists(list, index + 1, right);
        return mergeList(list1, list2);
    }

    private ListNode mergeList(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 == null) {
            cur.next = list2;
        } else {
            cur.next = list1;
        }
        return dummy.next;
    }
}
