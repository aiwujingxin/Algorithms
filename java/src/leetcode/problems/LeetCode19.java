package leetcode.problems;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/18 15:29
 */
public class LeetCode19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        cur = dummy;
        for (int i = 0; i < len - n - 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }
}
