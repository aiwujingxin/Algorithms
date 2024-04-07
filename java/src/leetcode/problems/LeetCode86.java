package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/25 22:00
 */
public class LeetCode86 {

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val >= x) {
                // find
                ListNode right = cur.next;
                while (right.next != null && right.next.val >= x) {
                    right = right.next;
                }
                if (right.next == null) {
                    return dummy.next;
                }
                ListNode next = right.next;
                // 断开
                right.next = next.next;
                // 插入
                next.next = cur.next;
                cur.next = next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
