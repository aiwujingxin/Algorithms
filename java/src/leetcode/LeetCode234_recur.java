package leetcode;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/18 23:31
 */
public class LeetCode234_recur {

    ListNode cur;

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        cur = head;
        return check(head);
    }

    private boolean check(ListNode head) {
        if (head == null) {
            return true;
        }
        if (!check(head.next)) {
            return false;
        }
        if (head.val == cur.val) {
            cur = cur.next;
            return true;
        }
        return false;
    }
}
