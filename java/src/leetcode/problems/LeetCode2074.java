package leetcode.problems;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/9 11:38
 */
public class LeetCode2074 {

    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        int length = 1;
        while (cur.next != null) {
            ListNode tail = cur;
            int count = 0;
            for (int i = 0; i < length && tail.next != null; i++) {
                tail = tail.next;
                count++;
            }
            if (count % 2 == 0) {
                ListNode start = cur.next;
                ListNode next = tail.next;
                cur.next = reverse(start, next);
                start.next = next;
                cur = start; // cur移动到反转后组的尾部
            } else {
                cur = tail; // 奇数组不反转，直接跳过
            }
            length++;
        }
        return dummy.next;
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

