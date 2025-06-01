package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/25 14:51
 */
public class LeetCode234 {

    public boolean isPalindrome(ListNode head) {
        ListNode mid = getMid(head);
        ListNode rHead = mid.next;
        mid.next = null;
        rHead = reverse(rHead);
        while (head != null && rHead != null) {
            if (head.val != rHead.val) {
                return false;
            }
            head = head.next;
            rHead = rHead.next;
        }
        return true;
    }

    private ListNode getMid(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
