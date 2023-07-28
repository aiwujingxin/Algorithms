package leetcode.lists.topinterview;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/24 23:19
 */
public class LeetCode148 {

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode sorted = head;
        ListNode cur = head.next;

        while (cur != null) {
            if (cur.val > sorted.val) {
                sorted = sorted.next;
            } else {
                ListNode pre = dummy;
                while (pre.next.val < cur.val) {
                    pre = pre.next;
                }
                //fixed
                sorted.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }
            cur = sorted.next;
        }
        return dummy.next;
    }
}
