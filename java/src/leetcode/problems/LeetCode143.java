package leetcode.problems;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/2 13:32
 */
public class LeetCode143 {

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = getMid(head);
        ListNode rhead = mid.next;
        mid.next = null;
        rhead = reverse(rhead);
        merge(head, rhead);
    }

    private void merge(ListNode l1, ListNode l2) {
        ListNode cur = l1;
        while (l2 != null) {
            ListNode next = cur.next;
            cur.next = l2;
            l2 = l2.next;
            cur = cur.next;
            cur.next = next;
            cur = next;
        }
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
}
