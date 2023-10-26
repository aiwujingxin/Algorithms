package leetcode.problems;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/27 04:02
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
                ListNode fast = cur.next;
                while (fast.next != null && fast.next.val >= x) {
                    fast = fast.next;
                }
                if (fast.next == null) {
                    return dummy.next;
                }
                ListNode node = fast.next;
                fast.next = fast.next.next;
                node.next = cur.next;
                cur.next = node;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
