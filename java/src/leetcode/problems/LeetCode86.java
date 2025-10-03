package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/11 11:27
 */
public class LeetCode86 {

    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(), big = new ListNode();
        ListNode s = small, b = big;
        while (head != null) {
            if (head.val < x) {
                s.next = head;
                s = s.next;
            } else {
                b.next = head;
                b = b.next;
            }
            head = head.next;
        }

        b.next = null;     // 防止成环
        s.next = big.next; // 连接两个链表
        return small.next;
    }
}
