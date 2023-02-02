package leetcode.plan.algorithm.level1;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/9 21:41
 */
public class LeetCode19 {
    //                c f
    //  1 2 3 4 5 6 7 8 9

    //n = 3

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode first = dummy;
        while (n > 0) {
            first = first.next;
            n--;
        }
        ListNode cur = dummy;
        while (first.next != null) {
            cur = cur.next;
            first = first.next;
        }

        cur.next = cur.next.next;
        return dummy.next;
    }
}
