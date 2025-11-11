package knowledge.mathematics.impl;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 11/11/25 22:43
 */
public class LinkedListSub {

    // 简化版：假设 l1 代表的数 >= l2 代表的数
    public ListNode subtractTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int borrow = 0;
        while (l1 != null) { // 循环直到 l1 结束
            int val1 = l1.val;
            int val2 = (l2 != null) ? l2.val : 0;
            int diff = val1 - val2 - borrow;
            if (diff < 0) {
                diff += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            current.next = new ListNode(diff);
            current = current.next;
            l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        // --- 处理结果中的前导零 ---
        // 比如 105 - 95 = 10，结果链表是 0 -> 1 -> null
        // 我们需要去掉末尾的 0 (因为链表是逆序的)
        ListNode resultHead = dummyHead.next;
        ListNode lastNonZero = null;
        ListNode temp = resultHead;
        // 找到最后一个非零节点
        while (temp != null) {
            if (temp.val != 0) {
                lastNonZero = temp;
            }
            temp = temp.next;
        }
        // 如果整个结果都是0 (e.g., 5-5)
        if (lastNonZero == null) {
            return new ListNode(0);
        }
        // 断开最后一个非零节点之后的链条
        lastNonZero.next = null;
        return resultHead;
    }
}
