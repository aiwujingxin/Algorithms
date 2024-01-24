package leetcode.problems;

import common.ListNode;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/24 11:57
 */
public class LeetCode2487 {

    public ListNode removeNodes(ListNode head) {
        ListNode newHead = reverse(head);
        Stack<Integer> stack = new Stack<>();
        ListNode dummy = new ListNode();
        dummy.next = newHead;
        ListNode cur = dummy;
        while (cur.next != null) {
            ListNode node = cur.next;
            while (!stack.isEmpty() && stack.peek() <= node.val) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
            stack.push(node.val);
        }
        return reverse(dummy.next);
    }

    private ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
