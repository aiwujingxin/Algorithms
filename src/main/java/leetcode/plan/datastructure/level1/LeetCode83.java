package leetcode.plan.datastructure.level1;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/12 22:32
 */
public class LeetCode83 {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy.next;

        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
