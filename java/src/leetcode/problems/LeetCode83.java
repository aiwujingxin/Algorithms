package leetcode.problems;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/11 18:12
 */
public class LeetCode83 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            ListNode t = cur.next;
            while (t != null && t.val == cur.val) {
                t = t.next;
            }
            cur.next = t;
            cur = t;
        }
        return head;
    }
}
