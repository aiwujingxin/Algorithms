package leetcode.lists.hot100;

import common.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/9/11 23:11
 */
public class LeetCode2 {

    // fix case
    //[9,9,9,9,9,9,9]
    //[9,9,9,9]


    int flag = 0;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        addTwoNumbers(l1, l2, dummy);
        return dummy.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2, ListNode dummy) {
        if (l1 == null && l2 == null) {
            if (flag == 1) {
                dummy.next = new ListNode(1);
                return dummy;
            }
        }
        int num1 = l1 == null ? 0 : l1.val;
        int num2 = l2 == null ? 0 : l2.val;

        int sum = num1 + num2 + flag;
        flag = sum / 10;

        ListNode node = new ListNode(sum % 10);
        dummy.next = node;
        return addTwoNumbers(l1 == null ? null : l1.next, l2 == null ? null : l2.next, node);
    }
}

