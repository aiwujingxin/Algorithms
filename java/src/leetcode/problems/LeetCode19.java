package leetcode.problems;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/18 15:29
 */
public class LeetCode19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode f = dummy, s = dummy;
        for (int i = 0; i <= n; i++) f = f.next;
        while (f != null) {
            f = f.next;
            s = s.next;
        }
        s.next = s.next.next;
        return dummy.next;
    }
}
