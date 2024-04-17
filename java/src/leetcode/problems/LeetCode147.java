package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/17 14:47
 */
public class LeetCode147 {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-50000);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val >= cur.val) {
                cur = cur.next;
            } else {
                ListNode f = dummy;
                while (f.next != null && f.next.val < cur.next.val) {
                    f = f.next;
                }
                ListNode next = cur.next;
                cur.next = cur.next.next;
                next.next = f.next;
                f.next = next;
            }
        }
        return dummy.next;
    }
}
