package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 16:07
 */
public class LeetCode25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }
        ListNode newHead = reverse(head, tail);
        head.next = reverseKGroup(tail, k);
        return newHead;
    }

    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != tail) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseKGroup_iter(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prevGroupEnd = dummy;
        ListNode curr = head;
        while (hasKNodes(curr, k)) {
            ListNode groupStart = curr;
            ListNode prev = null;
            // 反转k个节点
            for (int i = 0; i < k; i++) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            // 接回链表
            prevGroupEnd.next = prev;
            groupStart.next = curr;
            // 移动 prevGroupEnd
            prevGroupEnd = groupStart;
        }
        return dummy.next;
    }

    private boolean hasKNodes(ListNode node, int k) {
        for (int i = 0; i < k; i++) {
            if (node == null) return false;
            node = node.next;
        }
        return true;
    }
}
