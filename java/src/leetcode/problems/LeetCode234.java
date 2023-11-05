package leetcode.problems;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/5 14:35
 */
public class LeetCode234 {


    ListNode cur;

    public boolean isPalindrome(ListNode head) {
        this.cur = head;
        return check(head);
    }

    private boolean check(ListNode head) {
        if (head == null) {
            return true;
        }
        if (!check(head.next)) {
            return false;
        }

        if (head.val != cur.val) {
            return false;
        }

        cur = cur.next;
        return true;
    }
}
