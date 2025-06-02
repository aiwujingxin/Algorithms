package leetcode.problems;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 15:59
 */
public class LeetCode24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

    public ListNode swapPairs_iter(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;
            // 交换这两个节点
            pre.next = second;
            first.next = second.next;
            second.next = first;
            // 更新指针，准备下一对
            pre = first;
            head = first.next;
        }
        return dummy.next;
    }
}
