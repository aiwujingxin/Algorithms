package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/11 11:27
 */
public class LeetCode86 {

    public ListNode partition(ListNode head, int x) {
        ListNode smallDummy = new ListNode();
        ListNode bigDummy = new ListNode();
        ListNode small = smallDummy, big = bigDummy;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        big.next = null;        // 防止链表成环
        small.next = bigDummy.next;
        return smallDummy.next;
    }
}
