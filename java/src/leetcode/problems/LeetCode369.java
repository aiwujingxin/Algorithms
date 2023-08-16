package leetcode.problems;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/24 18:07
 */
public class LeetCode369 {


    int flag = 0;

    public ListNode plusOne(ListNode head) {
        dfs(head);
        if (flag == 1) {
            ListNode dummy = new ListNode(1);
            dummy.next = head;
            return dummy;
        }
        return head;
    }

    public void dfs(ListNode node) {
        if (node == null) {
            return;
        }
        dfs(node.next);

        int sum = node.val + flag + (node.next == null ? 1 : 0);
        node.val = sum % 10;
        flag = sum / 10;
    }
}
