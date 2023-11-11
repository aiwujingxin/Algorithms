package leetcode.problems;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/11 20:51
 */
public class LeetCode83 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;

        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
