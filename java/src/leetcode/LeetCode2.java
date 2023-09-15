package leetcode;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/15 22:43
 */
public class LeetCode2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int sign = 0;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int sum = a + b + sign;
            sign = (sum) / 10;
            cur.next = new ListNode((sum) % 10);
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            cur = cur.next;
        }

        if (sign == 1 ) {
            cur.next  =new ListNode(1);
        }
        return dummy.next;
    }
}
