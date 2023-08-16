package leetcode.problems;

import common.ListNode;

/**
 * @author jingxinwu
 * @date 2021-06-16 11:24 下午
 */
public class LeetCode24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextNode = head.next;
        head.next = swapPairs(nextNode.next);
        nextNode.next = head;
        return nextNode;
    }

}
