package leetcode.lists.LCR;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/23 20:57
 */
public class LCR24 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
