package knowledge.mathematics.impl;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 11/11/25 22:42
 */
public class LinkedListAdd {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); // 虚拟头节点
        ListNode current = dummyHead;
        int carry = 0;
        // 只要任一链表未结束，或还有进位，就继续
        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            int sum = val1 + val2 + carry;
            carry = sum / 10; // 更新进位
            // 创建新节点，值为当前位的数字
            current.next = new ListNode(sum % 10);
            current = current.next; // 移动 current 指针
            // 移动 l1 和 l2 的指针
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return dummyHead.next;
    }
}
