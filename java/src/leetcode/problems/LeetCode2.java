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
            return dfs(l1, l2, 0);
        }

        private ListNode dfs(ListNode l1, ListNode l2, int sum) {
            // Base Case 1: 都为空，看是否还有最后遗留的进位
            if (l1 == null && l2 == null) {
                return sum > 0 ? new ListNode(sum) : null;
            }
            // 【核心优化：剪枝】
            // 如果 l1 为空且没有进位了，直接返回 l2 剩下的整条链表，瞬间结束！
            if (l1 == null && sum == 0) return l2;
            // 同理，如果 l2 为空且没有进位了，直接返回 l1
            if (l2 == null && sum == 0) return l1;
            // 正常计算当前位
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            ListNode node = new ListNode(sum % 10);
            node.next = dfs(l1, l2, sum / 10);
            return node;
        }
    }
}
