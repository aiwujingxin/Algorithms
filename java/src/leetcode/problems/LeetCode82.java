package leetcode.problems;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/11 20:56
 */
public class LeetCode82 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            //基准
            int val = cur.next.val;
            if (val == cur.next.next.val) {
                while (cur.next != null && cur.next.val == val) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
