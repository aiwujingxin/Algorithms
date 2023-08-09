package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/11 22:28
 */
public class LeetCode21 {


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        mergeTwoLists(list1, list2, dummy);
        return dummy.next;
    }

    public void mergeTwoLists(ListNode list1, ListNode list2, ListNode cur) {
        if (list1 == null) {
            cur.next = list2;
            return;
        }
        if (list2 == null) {
            cur.next = list1;
            return;
        }
        if (list1.val < list2.val) {
            cur.next = list1;
            mergeTwoLists(list1.next, list2, cur.next);
        } else {
            cur.next = list2;
            mergeTwoLists(list1, list2.next, cur.next);
        }
    }
}
