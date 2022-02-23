package codeTop.ms;

import common.ListNode;

/**
 * @author jingxinwu
 * @date 2022-02-23 1:22 PM
 */
public class Number0205 {

    /**
     * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
     * 输出：2 -> 1 -> 9，即912
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int flag = 0;
        while (l1 != null || l2 != null) {

            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;

            int sum = num1 + num2 + flag;

            flag = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        //fix 最后的进位
        if (flag == 1) {
            cur.next = new ListNode(1);
        }

        return dummy.next;
    }
}
