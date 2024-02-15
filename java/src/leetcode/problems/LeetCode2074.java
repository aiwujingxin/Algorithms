package leetcode.problems;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/9 11:38
 */
public class LeetCode2074 {

    public ListNode reverseEvenLengthGroups(ListNode head) {
        if (head == null) {
            return null;
        }
        int groupLen = 1;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while (cur != null) {
            ListNode tail = cur;
            int len = 0;
            for (int i = 0; i < groupLen; i++) {
                tail = tail.next;
                len++;
                if (tail == null) {
                    if (len % 2 == 0) {
                        ListNode start = cur.next;
                        cur.next = reverse(start, null);
                    }
                    return dummy.next;
                }
            }
            if (groupLen % 2 == 0) {
                ListNode start = cur.next;
                ListNode next = tail.next;
                reverse(start, tail.next);
                cur.next = tail;
                start.next = next;
                cur = start;
            } else {
                cur = tail;
            }
            groupLen++;
        }
        return head;
    }

    public ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != tail) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

