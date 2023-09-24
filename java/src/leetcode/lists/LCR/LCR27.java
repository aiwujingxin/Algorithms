package leetcode.lists.LCR;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/23 21:06
 */
public class LCR27 {

    ListNode cur;

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        cur = head;
        return dfs(head);
    }

    private boolean dfs(ListNode head) {
        if (head == null) {
            return true;
        }

        if (!dfs(head.next)) {
            return false;
        }
        if (head.val != cur.val) {
            return false;
        }
        cur = cur.next;
        return true;
    }

}

