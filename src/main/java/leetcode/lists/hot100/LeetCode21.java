package leetcode.lists.hot100;

import common.ListNode;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/9/11 23:28
 */
public class LeetCode21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode dummy = new ListNode();
        mergeTwoLists(list1, list2, dummy);
        return dummy.next;

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2, ListNode dummy) {
        if (list1 == null && list2 == null) {
            return dummy;
        }
        if (list1 == null) {
            dummy.next = list2;
            return dummy;
        }
        if (list2 == null) {
            dummy.next = list1;
            return dummy;
        }
        if (list1.val <= list2.val) {
            dummy.next = list1;
            return mergeTwoLists(list1.next, list2, dummy.next);
        } else {
            dummy.next = list2;
            return mergeTwoLists(list1, list2.next, dummy.next);
        }
    }
}
