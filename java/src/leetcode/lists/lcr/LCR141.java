package leetcode.lists.lcr;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/12 21:44
 */
public class LCR141 {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
