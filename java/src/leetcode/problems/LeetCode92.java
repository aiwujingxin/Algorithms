package leetcode.problems;

import common.ListNode;

/**
 * @author jingxinwu
 * @date 2021-07-01 11:52 下午
 */
public class LeetCode92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode cur = pre.next;
        ListNode temp = cur.next;
        for (int i = 0; i < right - left; i++) {
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
            temp = cur.next;
        }
        return dummy.next;
    }

}
