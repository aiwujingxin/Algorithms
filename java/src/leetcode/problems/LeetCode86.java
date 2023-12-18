package leetcode.problems;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/18 17:18
 */
public class LeetCode86 {

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;

        while (cur != null) {
            if (cur.next != null && cur.next.val >= x) {
                ListNode t = cur.next;
                while (t.next != null && t.next.val >= x) {
                    t = t.next;
                }
                if (t.next == null) {
                    return dummy.next;
                }
                ListNode next = t.next.next;
                t.next.next = cur.next;
                cur.next = t.next;
                t.next = next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
