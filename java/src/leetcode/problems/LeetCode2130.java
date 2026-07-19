package leetcode.problems;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 6/14/26 17:23
 */
public class LeetCode2130 {

    public int pairSum(ListNode head) {
        ListNode mid = findMid(head);
        ListNode next = mid.next;
        mid.next = null;
        ListNode rHead = reverse(next);
        ListNode cur1 = head;
        ListNode cur2 = rHead;
        int max = 0;
        while (cur1 != null) {
            max = Math.max(max, cur1.val + cur2.val);
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return max;
    }

    private ListNode reverse(ListNode head) {
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

    private ListNode findMid(ListNode head) {
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
}
