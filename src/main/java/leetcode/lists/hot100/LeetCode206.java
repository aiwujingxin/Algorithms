package leetcode.lists.hot100;

import common.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/9/11 23:37
 */
public class LeetCode206 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return next;
    }
}
