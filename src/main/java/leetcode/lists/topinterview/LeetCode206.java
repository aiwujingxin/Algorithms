package leetcode.lists.topinterview;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/27 15:44
 */
public class LeetCode206 {

    public ListNode reverseList(ListNode head) {

        if (head == null) {
            return head;
        }
        //     1      2      3     4
        //     pre    cur   next
        ListNode pre = head;
        ListNode cur = head.next;
        pre.next  = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;
        }
        return pre;
    }
}
