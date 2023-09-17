package leetcode;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/17 23:47
 */
public class LeetCode206 {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }
        return pre;
    }
}
