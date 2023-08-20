package leetcode;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/16 21:16
 * <a href="https://leetcode.cn/problems/add-two-numbers-ii/solution/shu-ju-jie-gou-dfsqiu-he-chang-du-bu-yi-de-lian-bi/">...</a>
 */
public class LeetCode445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        int len1 = length(l1);
        int len2 = length(l2);


        ListNodePlus plus = len1 >= len2 ? dfs(l1, l2, len1, len2) : dfs(l2, l1, len2, len1);
        if (plus.carry == 1) {
            ListNode head = new ListNode(1);
            head.next = plus.head;
            return head;
        }
        return plus.head;
    }

    private ListNodePlus dfs(ListNode l1, ListNode l2, int len1, int len2) {
        ListNodePlus plus;
        if (len1 == 1 && len2 == 1) {
            int sum = l1.val + l2.val;
            l1.val = sum % 10;
            plus = new ListNodePlus(l1, sum / 10); // 初始化plus，这个plus后面递归会复用
            return plus;
        }

        if (len1 > len2) {
            plus = dfs(l1.next, l2, len1 - 1, len2);
            l1.next = plus.head; // next + carry的封装
            int sum = plus.carry + l1.val;
            l1.val = sum % 10;
            plus.head = l1; // 复用next返回的plus
            plus.carry = sum / 10;
        } else { // len1 == len2
            plus = dfs(l1.next, l2.next, len1 - 1, len2 - 1);
            int sum = l1.val + l2.val + plus.carry;
            l1.val = sum % 10;
            plus.head = l1;
            plus.carry = sum / 10;
        }
        return plus; // 返回给 l1 的pre节点
    }

    private int length(ListNode node) {
        int len = 0;
        ListNode cur = node;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
    }

    private static class ListNodePlus {
        int carry;
        ListNode head;

        public ListNodePlus(ListNode head, int carry) {
            this.carry = carry;
            this.head = head;
        }
    }
}
