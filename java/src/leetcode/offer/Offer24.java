package leetcode.offer;

import common.ListNode;

/**
 * @author jingxinwu
 * @date 2021-11-21 6:11 下午
 */
public class Offer24 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre.next = temp;

            pre = cur;
            cur = temp;
        }

        return pre;
    }

}
