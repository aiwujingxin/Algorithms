package leetcode;

import common.ListNode;

/**
 * @author jingxinwu
 * @date 2021-06-26 3:36 下午
 */
public class LeetCode82 {


    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode();
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode real = dummy;

        while (cur != null) {

            if ((cur.val != pre.val || pre == dummy)
                    && (cur.next != null && cur.val != cur.next.val)) {
                real.next = cur;
                real = cur;
            }
            pre = cur;
            cur = cur.next;
            real.next = null; // 断开连接，只加入真正有效的节点
        }

        return dummy.next;
    }
}
