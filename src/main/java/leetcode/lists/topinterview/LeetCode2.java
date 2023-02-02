package leetcode.lists.topinterview;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/20 23:45
 */
public class LeetCode2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        int flag = 0;

        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        while (l1 != null || l2 != null) {
            int one = l1 == null ? 0 : l1.val;
            int two = l2 == null ? 0 : l2.val;

            int sum = one + two + flag;

            cur.next = new ListNode(sum % 10);

            flag = sum / 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            cur = cur.next;
        }

        if (flag == 1) {
            cur.next = new ListNode(1);
        }

        return dummy.next;
    }
}
