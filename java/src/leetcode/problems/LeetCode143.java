package leetcode.problems;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/2 13:32
 */
public class LeetCode143 {

    public void reorderList(ListNode head) {
        ListNode mid = getMid(head);
        ListNode rhead = mid.next;
        mid.next = null;
        rhead = reverse(rhead);
        merge(head, rhead);
    }

    private void merge(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p2 != null) {
            ListNode p1Next = p1.next;  // 记录 l1 下一个节点
            ListNode p2Next = p2.next;  // 记录 l2 下一个节点
            p1.next = p2;               // l1节点指向 l2节点
            p2.next = p1Next;           // l2节点指向 l1的下一个节点
            p1 = p1Next;                // p1前进一位
            p2 = p2Next;                // p2前进一位
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
