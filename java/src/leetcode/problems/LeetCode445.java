package leetcode.problems;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/30 22:55
 */
public class LeetCode445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2); // l1 和 l2 反转后，就变成【2. 两数相加】了
        ListNode l3 = addTwo(l1, l2);
        return reverse(l3);
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    private ListNode addTwo(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(); // 哨兵节点
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null) carry += l1.val;
            if (l2 != null) carry += l2.val;
            cur = cur.next = new ListNode(carry % 10);
            carry /= 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return dummy.next;
    }
}
