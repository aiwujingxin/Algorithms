package leetcode.problems;

import common.*;

/**
 * @author jingxinwu
 * @date 2021-08-01 12:34 下午
 */
public class LeetCode143_mid {


    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        //寻找中点
        ListNode mid = findMid(head);
        //反转链表
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = revert(l2);
        ListNode l1 = head;
        //拼接链表
        while (l1 != null && l2 != null) {
            ListNode next = l1.next;
            l1.next = l2;
            l2 = l2.next;
            l1.next.next = next;
            l1 = next;
        }
    }


    private ListNode findMid(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }


    private ListNode revert(ListNode mid) {
        ListNode pre = null;
        ListNode cur = mid;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
