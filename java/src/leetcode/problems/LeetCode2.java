package leetcode.problems;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 10:25
 */
public class LeetCode2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(), cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(carry % 10);
            cur = cur.next;
            carry /= 10;
        }
        return dummy.next;
    }

    class Solution_DFS {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            return addTwoNumbers(l1, l2, 0);
        }

        private ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
            // 1. 终止条件
            if (l1 == null && l2 == null && carry == 0) return null;
            // 2. 先处理当前节点
            if (l1 != null) carry += l1.val;
            if (l2 != null) carry += l2.val;
            ListNode node = new ListNode(carry % 10);
            // 3. 再递归处理后面的，并连起来
            node.next = addTwoNumbers(l1 == null ? null : l1.next, l2 == null ? null : l2.next, carry / 10);
            // 4. 返回当前节点
            return node;
        }
    }
}
