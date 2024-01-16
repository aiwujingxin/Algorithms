package leetcode.problems;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/16 20:11
 */
public class LeetCode1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode();
        dummy.next = list1;
        ListNode aa = dummy;
        while (a > 0) {
            aa = aa.next;
            a--;
        }
        ListNode bb = list1;
        while (b > 0) {
            bb = bb.next;
            b--;
        }
        aa.next = list2;
        ListNode cur = aa;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = bb.next;
        return dummy.next;
    }
}
