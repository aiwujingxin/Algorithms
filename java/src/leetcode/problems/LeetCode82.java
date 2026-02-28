package leetcode.problems;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/11 18:10
 */
public class LeetCode82 {

    public ListNode deleteDuplicates12(ListNode head) {
        ListNode dummy = new ListNode(-101);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur != null) {
            ListNode t = cur.next;
            if (t != null && t.next != null && t.val == t.next.val) {
                while (t.next != null && t.val == t.next.val) {
                    t = t.next;
                }
                cur.next = t.next;
            } else {
                cur = t;
            }
        }
        return dummy.next;
    }
}
