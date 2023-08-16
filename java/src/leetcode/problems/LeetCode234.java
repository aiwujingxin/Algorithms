package leetcode.problems;

import common.ListNode;

/**
 * @author jingxinwu
 * @date 2021-12-12 11:55 PM
 */
public class LeetCode234 {


    public boolean isPalindrome(ListNode head) {

        ListNode mid = getMid(head);
        ListNode midNext = helper(mid.next);

        while (midNext != null) {

            if (head.val == midNext.val) {
                head = head.next;
                midNext = midNext.next;
            } else {
                return false;
            }

        }
        return true;
    }


    private ListNode getMid(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode s = head;
        ListNode f = head;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }

    private ListNode helper(ListNode head) {

        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
