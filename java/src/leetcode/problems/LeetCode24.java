package leetcode.problems;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 15:59
 */
public class LeetCode24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(head.next);
        newHead.next = head;
        return newHead;
    }
}
