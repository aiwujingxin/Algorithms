package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/11 11:27
 */
public class LeetCode86 {

    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val >= x) {
                ListNode curNext = cur.next;
                ListNode f = curNext;
                while (f.next != null && f.next.val >= x) {
                    f = f.next;
                }
                if (f.next == null) {
                    return dummy.next;
                }
                ListNode d = f.next;
                f.next = d.next;
                d.next = curNext;
                cur.next = d;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
