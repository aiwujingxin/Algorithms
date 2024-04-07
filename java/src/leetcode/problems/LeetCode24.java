package leetcode.problems;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/18 17:48
 */
public class LeetCode24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextHead = head.next;
        head.next = swapPairs(nextHead.next);
        nextHead.next = head;
        return nextHead;
    }
}
